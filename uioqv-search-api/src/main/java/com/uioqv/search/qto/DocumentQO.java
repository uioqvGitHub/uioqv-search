package com.uioqv.search.qto;

import com.uioqv.base.entity.BaseQO;

/**
 * @author LiuGuoQing
 * @since 2018-11-06
 */
public class DocumentQO extends BaseQO {
    public void documentName(String... documentName) {
        put("documentName", documentName);
    }
}
