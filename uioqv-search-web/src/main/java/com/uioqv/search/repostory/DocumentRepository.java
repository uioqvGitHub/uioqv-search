package com.uioqv.search.repostory;

import com.uioqv.base.entity.BaseQO;
import com.uioqv.search.domain.DocumentDO;
import com.uioqv.search.dto.DocumentDTO;
import com.uioqv.search.mapper.QueryMapper;
import com.uioqv.search.qto.DocumentQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
public abstract class DocumentRepository extends BaseRepository implements ReactiveCrudRepository<DocumentDO, String> {


    public abstract Mono<Boolean> existsByDocumentName(String documentName);
}
