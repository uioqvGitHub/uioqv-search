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
@Getter
@Setter
@ToString
public class ProjectDTO implements Serializable {
    private static final long serialVersionUID = 20181023192426L;

    private String          id;
    private String  projectName;
    private String  database;
    private String  documentId;
    private LocalDateTime dateCreate;
}
