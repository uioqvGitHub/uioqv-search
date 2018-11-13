package com.uioqv.search.dto;


import com.uioqv.base.entity.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Getter
@Setter
@ToString
public class IndexDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = 20181023113600L;

    private String      indexName;


    private List<ProjectDTO> projects;
}
