package com.uioqv.search.dto;

import com.uioqv.base.entity.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */

@ToString
@Getter
@Setter
public class FieldDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = 20181023192426L;
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
    private Boolean stored;
    private Boolean tokenized;
    private Boolean storeTermVectors;
    private Boolean storeTermVectorOffsets;
    private Boolean storeTermVectorPositions;
    private Boolean storeTermVectorPayloads;
    private Boolean omitNorms;
    private String  indexOptions;
    private Boolean frozen;
    private String  docValuesType;
    private Integer dimensionCount;
    private Integer dimensionNumBytes;
}
