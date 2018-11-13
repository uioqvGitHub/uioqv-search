package com.uioqv.search.repostory;

import com.uioqv.search.domain.IndexProjectDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author LiuGuoQing
 * @since 2018-11-13
 */
public interface IndexProjectRepository extends ReactiveCrudRepository<IndexProjectDO, String> {
}
