package com.uioqv.search.mapper.conver;


/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
public class BooleanConver {
    public Boolean toBoolean(Integer code) {
        if(code == null) {
            return null;
        }
        return code != 0;
    }
    public Integer toInteger(Boolean bool) {
        if(bool == null) {
            return null;
        }
        return bool? 1 : 0;
    }
}
