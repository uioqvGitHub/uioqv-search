package com.uioqv.search.domain;

import com.uioqv.base.entity.BaseDO;
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
public class FieldDO extends BaseDO {

    /**
     * 所属文档id
     */
    private String  documentId;
    /**
     * 所属项目id
     */
    private String  projectId;
    /**
     * 所属索引id
     */
    private String  indexId;
    /**
     * 字段名
     */
    private String  fieldName;

    private Integer stored;
    private Integer tokenized;
    private Integer storeTermVectors;
    private Integer storeTermVectorOffsets;
    private Integer storeTermVectorPositions;
    private Integer storeTermVectorPayloads;
    private Integer omitNorms;
    private String  indexOptions;
    private Integer frozen;
    private String  docValuesType;
    private Integer dimensionCount;
    private Integer dimensionNumBytes;


}
