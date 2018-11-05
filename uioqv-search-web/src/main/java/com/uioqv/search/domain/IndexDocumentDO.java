package com.uioqv.search.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Document
@Getter
@Setter
public class IndexDocumentDO extends BaseDO {
    private String documentName;

}
