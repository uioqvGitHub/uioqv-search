package com.uioqv.search.repostory;

import com.uioqv.search.domain.IndexDocumentDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
public interface IndexDocumentRepository extends ReactiveCrudRepository<IndexDocumentDO, String> {

}
