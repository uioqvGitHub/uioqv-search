package com.uioqv.search.domain;

import com.uioqv.base.entity.BaseDO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Getter
@Setter
@Document
public class IndexDO extends BaseDO {
    /**
     * 索引名
     */
    @Indexed(unique = true)
    private String      indexName;

}
