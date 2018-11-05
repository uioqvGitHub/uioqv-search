package com.uioqv.search.service.impl;

import com.uioqv.search.dto.ProjectDTO;
import com.uioqv.search.exception.ParamException;
import com.uioqv.search.mapper.ProjectMapper;
import com.uioqv.search.repostory.IndexDocumentRepository;
import com.uioqv.search.repostory.ProjectRepository;
import com.uioqv.search.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    private IndexDocumentRepository documentRepository;


    @Override
    public Mono<ProjectDTO> createProject(Mono<ProjectDTO> project) {
        return project.flatMap((p) -> {
            if(StringUtils.isBlank(p.getDocumentId())) {
                log.error("ProjectServiceImpl.createProject 项目无绑定文档id");
                throw new ParamException("项目无绑定文档id");
            }
            return documentRepository.findById(p.getDocumentId()).flatMap((d) -> {
                if(d == null) {
                    log.error("ProjectServiceImpl.createProject 查询不到该文档 documentId:{}", p.getDocumentId());
                    throw new ParamException("查询不到该文档");
                }
                return projectRepository.save(ProjectMapper.INSTANCE.dtoToDO(p))
                        .map(ProjectMapper.INSTANCE::doToDTO);
            });
        });
    }

    @Override
    public Flux<ProjectDTO> findProject() {
        return projectRepository.findAll().map(ProjectMapper.INSTANCE::doToDTO);
    }
}
