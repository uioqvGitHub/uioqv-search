package com.uioqv.search.repostory;

import com.uioqv.search.domain.ProjectDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
public interface ProjectRepository extends ReactiveCrudRepository<ProjectDO, String> {
    Mono<Boolean> existsByDocumentIdAndProjectName(String documentId, String projectName);
}
