package com.uioqv.search.dto;


import com.uioqv.search.enums.SourceTypeEnum;
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
public class IndexCreateDTO implements Serializable {
    private static final long serialVersionUID = 20181023113600L;
    private String          id;
    private LocalDateTime   dateCreate;
}
