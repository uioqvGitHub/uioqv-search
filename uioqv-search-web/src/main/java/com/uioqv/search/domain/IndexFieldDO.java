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
public class IndexFieldDO extends BaseDO {

    private String  docuemntId;
    private String  projectId;
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
