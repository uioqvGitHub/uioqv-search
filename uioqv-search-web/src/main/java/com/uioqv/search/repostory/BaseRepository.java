package com.uioqv.search.repostory;

import com.uioqv.base.entity.BaseQO;
import com.uioqv.search.domain.DocumentDO;
import com.uioqv.search.mapper.QueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;

/**
 * @author LiuGuoQing
 * @since 2018-11-13
 */
public class BaseRepository {
    @Autowired
    private ReactiveMongoTemplate rmt;

    public <T> Flux<T> findByQuery(BaseQO qo, Class<T> clazz) {
        Query query = QueryMapper.INSTANCE.conver(qo);
        return rmt.find(query, clazz);
    }
}
