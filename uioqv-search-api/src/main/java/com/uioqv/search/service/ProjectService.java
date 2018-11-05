package com.uioqv.search.service;

import com.uioqv.search.dto.ProjectDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-24
 */
public interface ProjectService {

    /**
     * 创建一个项目
     * @param project
     * @return
     */
    Mono<ProjectDTO> createProject(Mono<ProjectDTO> project);

    Flux<ProjectDTO> findProject();
}
