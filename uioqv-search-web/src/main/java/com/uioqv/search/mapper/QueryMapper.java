package com.uioqv.search.mapper;

import com.uioqv.base.entity.BaseQO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.Map;

/**
 * @author LiuGuoQing
 * @since 2018-11-13
 */
@Mapper
public interface QueryMapper {
    QueryMapper INSTANCE = Mappers.getMapper(QueryMapper.class);

    class Utils {
        Criteria eqOrIn(BaseQO qo, String key) {
            Criteria criteria = Criteria.where(key);
            String[] keys = qo.get(key, String[].class);
            if(keys != null) {
                if(keys.length == 1) {
                    criteria.equals(keys[0]);
                } else if (keys.length > 1) {
                    criteria.in(keys);
                }
            }
            return criteria;
        }

        Criteria gte(BaseQO qo, String key, String leftKey) {
            Criteria criteria = Criteria.where(key)
                    .gte(qo.get(leftKey, Object.class));
            return criteria;
        }

        Criteria lt(BaseQO qo, String key, String rightKey) {
            Criteria criteria = Criteria.where(key)
                    .lt(qo.get(rightKey, Object.class));
            return criteria;
        }

    }

    /**
     * 将qo转换为Query
     * @param qo
     * @return
     */
    default Query conver(BaseQO qo) {
        if(qo == null) {
            return null;
        }
        Criteria criteria = new Criteria();
        Map<String, Object> map = qo.getMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if(key.endsWith("Max")) {
                criteria.andOperator(new Utils().lt(qo, key.substring(0, key.length() - 3), key));
            } else if(key.endsWith("Min")) {
                criteria.andOperator(new Utils().gte(qo, key.substring(0, key.length() - 3), key));
            } else {
                criteria.andOperator(new Utils().eqOrIn(qo, key));
            }
        }
        Query query = Query.query(criteria);
        query.with(qo.getPage());
        query.with(qo.getSort());
        return query;
    }
}
