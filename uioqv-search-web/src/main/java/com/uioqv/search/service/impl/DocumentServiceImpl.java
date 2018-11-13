package com.uioqv.search.service.impl;

import com.uioqv.base.utils.Checks;
import com.uioqv.search.dto.DocumentDTO;
import com.uioqv.search.mapper.DocumentMapper;
import com.uioqv.search.qto.DocumentQO;
import com.uioqv.search.repostory.DocumentRepository;
import com.uioqv.search.repostory.IndexRepository;
import com.uioqv.search.repostory.ProjectRepository;
import com.uioqv.search.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-24
 */
@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private IndexRepository indexRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Mono<DocumentDTO> createDocument(Mono<DocumentDTO> documentMono) {
        log.info("DocumentServiceImpl.createDocument 创建文档 data:{}", documentMono);
        return documentMono.flatMap((d) -> {
            Checks.init()
                    .message("创建文档不能为空")
                    .data(d)
                    .isNotNull(d);
            Checks.init()
                    .message("文档名不能为空")
                    .data(d)
                    .isNotBlank(d.getDocumentName());
            Checks.init()
                    .message("所属索引不能为空")
                    .data(d)
                    .isNotBlank(d.getIndexId());
            Checks.init()
                    .message("所属项目不能为空")
                    .data(d)
                    .isNotBlank(d.getProjectId());


            return documentRepository.existsByDocumentName(d.getDocumentName())
                    .filter((exists) -> {
                        //校验文档名是否重复
                        Checks.init()
                                .message("文档名不能重复")
                                .data(d)
                                .isFalse(exists);
                        return true;
                    }).flatMap(
                            //校验所属索引是否存在
                            e -> indexRepository.existsById(d.getIndexId())
                                    .filter( (exists) -> {
                                        Checks.init()
                                                .message("所属索引不存在")
                                                .data(d)
                                                .isTrue(exists);
                                        return true;
                                    })
                    ).flatMap(
                            //校验所属项目是否存在
                            e-> projectRepository.existsById(d.getProjectId())
                                    .filter((exists) -> {
                                        Checks.init()
                                                .message("所属项目不存在")
                                                .data(d)
                                                .isTrue(exists);
                                        return true;
                                    })
                    ).flatMap(
                            //存储该文档
                            e -> documentRepository.save(DocumentMapper.INSTANCE.dtoToDO(d))
                                    .map(DocumentMapper.INSTANCE::doToDTO)
                    );
        });
    }

    @Override
    public Flux<DocumentDTO> findDocument(Mono<DocumentQO> documentQO) {
        return null;
    }


}
