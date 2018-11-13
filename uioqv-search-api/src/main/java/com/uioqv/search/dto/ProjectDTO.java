package com.uioqv.search.dto;

import com.uioqv.base.entity.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Getter
@Setter
@ToString
public class ProjectDTO  extends BaseDTO implements Serializable {
    private static final long serialVersionUID = 20181023192426L;

    private String  projectName;
    private String  database;
    private String  documentId;

    /**
     * 所属索引id
     */
    private List<IndexDTO> index;
}
