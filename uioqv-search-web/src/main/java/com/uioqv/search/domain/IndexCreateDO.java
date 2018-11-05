package com.uioqv.search.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Getter
@Setter
@Document
public class IndexCreateDO extends BaseDO {
    private String      source;
}
