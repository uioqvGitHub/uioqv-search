package com.uioqv.search.dto;

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
public class IndexFieldDTO implements Serializable {
    private static final long serialVersionUID = 20181023192426L;
    private String          id;
    private String  docuemntId;
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
    private LocalDateTime dateCreate;
}
