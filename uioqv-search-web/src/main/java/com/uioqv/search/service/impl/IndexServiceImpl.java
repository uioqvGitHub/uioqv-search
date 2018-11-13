package com.uioqv.search.service.impl;

import com.google.gson.Gson;
import com.uioqv.base.utils.Checks;
import com.uioqv.search.domain.IndexProjectDO;
import com.uioqv.search.dto.IndexDTO;
import com.uioqv.search.dto.ProjectDTO;
import com.uioqv.search.mapper.IndexMapper;
import com.uioqv.search.repostory.IndexProjectRepository;
import com.uioqv.search.repostory.IndexRepository;
import com.uioqv.search.repostory.ProjectRepository;
import com.uioqv.search.service.IndexCreateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Service
@Slf4j
public class IndexServiceImpl implements IndexCreateService {

    @Autowired
    private IndexRepository indexRepository;
    @Autowired
    private IndexProjectRepository indexProjectRepository;
    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public Mono<IndexDTO> createDocument(Mono<IndexDTO> indexMono) {
        return indexMono.flatMap((indexDTO) -> {
            Checks.init()
                    .message("索引名不能为空")
                    .data(indexDTO)
                    .isNotBlank(indexDTO.getIndexName());

            return indexRepository.existsByIndexName(indexDTO.getIndexName())
                    .filter(e-> {
                        Checks.init()
                                .message("索引名已经存在")
                                .data(indexDTO)
                                .isFalse(e);
                        return true;
                    }).flatMap(e -> {
                        return indexRepository.save(IndexMapper.INSTANCE.dtoToDO(indexDTO))
                                .map(IndexMapper.INSTANCE::doToDTO);
                    }).filter(e -> {
                        if(indexDTO.getProjects() != null) {
                            Flux.fromIterable(indexDTO.getProjects())
                                    .filter(index -> {
                                        //过滤项目id为空的
                                        if(StringUtils.isBlank(index.getId())) {
                                            log.error("IndexServiceImpl.createDocument 项目id为空, data:{}", new Gson().toJson(indexDTO));
                                        }
                                        return StringUtils.isNotBlank(index.getId());
                                    }).flatMap(index -> {
                                return Mono.just(index)
                                        .zipWith(projectRepository.findById(index.getDocumentId()));
                            }).filter(tuple2 ->{
                                //过滤根据项目id找不到项目的
                                if(tuple2.getT2() == null) {
                                    log.error("IndexServiceImpl.createDocument 项目不存在, unique:{} data:{}",tuple2.getT1().getDocumentId(), new Gson().toJson(indexDTO));
                                }
                                return tuple2.getT2() != null;
                            }).map(tuple2 -> {
                                return new IndexProjectDO(indexDTO.getId(), tuple2.getT2().getId());
                            }).map(indexProjectDO -> {
                                //建立索引与项目关系
                                log.info("IndexServiceImpl.createDocument 建立索引与项目关系, indexProject:{}", new Gson().toJson(indexProjectDO));
                                return indexProjectRepository.save(indexProjectDO)
                                        .filter( indexProject -> {
                                            //返回为null创建失败
                                            if(indexProject == null) {
                                                log.error("IndexServiceImpl.createDocument 建立索引与项目关系失败 data:{}", new Gson().toJson(indexProject));
                                            }
                                            return true;
                                        });
                            });
                        }
                        return true;
                    });
        });
    }
}
