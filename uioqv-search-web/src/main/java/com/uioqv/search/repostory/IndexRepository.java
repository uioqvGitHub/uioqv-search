package com.uioqv.search.repostory;

import com.uioqv.search.domain.IndexDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
public interface IndexRepository extends ReactiveCrudRepository<IndexDO, String> {

    Mono<Boolean> existsByIndexName(String indexName);
}
