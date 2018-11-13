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
@Getter
@ToString
@Setter
public class DocumentDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = 20181023192350L;
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
