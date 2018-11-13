package com.uioqv.search.domain;

import com.uioqv.base.entity.BaseDO;
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
public class DocumentDO extends BaseDO {

    private String documentName;
    /**
     * 所属项目id
     */
    private String  projectId;
    /**
     * 所属索引id
     */
    private String  indexId;
}
