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

@ToString
@Setter
public class IndexDocumentDTO implements Serializable {
    private static final long serialVersionUID = 20181023192350L;
    private String          id;
    private String documentName;
    private LocalDateTime dateCreate;
}
