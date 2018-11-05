package com.uioqv.search.exception;

/**
 * @author LiuGuoQing
 * @since 2018-10-25
 */
public class ParamException extends RuntimeException {
    public ParamException() {
        this("参数异常", null);
    }

    public ParamException(String massage) {
        this(massage, null);
    }

    public ParamException(String massage, Throwable throwable) {
        super(massage, throwable);
    }
}
