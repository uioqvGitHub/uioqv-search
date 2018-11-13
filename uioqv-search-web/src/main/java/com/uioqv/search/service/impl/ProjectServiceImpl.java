package com.uioqv.search.service.impl;

import com.google.gson.Gson;
import com.uioqv.base.utils.Checks;
import com.uioqv.search.dto.ProjectDTO;
import com.uioqv.search.mapper.ProjectMapper;
import com.uioqv.search.repostory.DocumentRepository;
import com.uioqv.search.repostory.ProjectRepository;
import com.uioqv.search.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private DocumentRepository documentRepository;


    @Override
    public Mono<ProjectDTO> createProject(Mono<ProjectDTO> project) {
        return project.flatMap((p) -> {
            log.info("ProjectServiceImpl.createProject 创建项目 data:{}", new Gson().toJson(p));
            Checks.init()
                    .message("创建项目参数不能为空")
                    .data(p)
                    .isNotNull(p);
            Checks.init()
                    .message("未录入绑定文档")
                    .data(p)
                    .isNotBlank(p.getDocumentId());
            return Mono.zip(
                    documentRepository.existsById(p.getDocumentId())
                            .filter((d) -> {
                                Checks.init()
                                        .message("查询不到该文档")
                                        .data(p)
                                        .isTrue(d);
                                return true;
                            }),
                    projectRepository.existsByDocumentIdAndProjectName(p.getDocumentId(), p.getProjectName())
                            .filter((exists) -> {
                                Checks.init()
                                        .message("同一文档下项目名不能重复")
                                        .data(p)
                                        .isFalse(exists);
                                return true;
                            })
                    ).flatMap((d) -> {
                        return projectRepository.save(ProjectMapper.INSTANCE.dtoToDO(p))
                                .map(ProjectMapper.INSTANCE::doToDTO);
                    });
        });
    }

    @Override
    public Flux<ProjectDTO> findProject() {
        log.info("ProjectServiceImpl.createProject  获取所有项目列表");
        return projectRepository.findAll().map(ProjectMapper.INSTANCE::doToDTO);
    }
}
