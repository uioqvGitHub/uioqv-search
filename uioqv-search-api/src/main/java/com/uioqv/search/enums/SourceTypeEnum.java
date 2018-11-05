package com.uioqv.search.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@AllArgsConstructor
@Getter
public enum SourceTypeEnum {
    UIOQV_SEARCH(1, "搜索服务")
    ;

    private int code;
    private String desc;
}
