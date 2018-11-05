package com.uioqv.search.exception;

/**
 * @author LiuGuoQing
 * @since 2018-10-25
 */
public class ResourcesException extends RuntimeException {
    public ResourcesException() {
        this("资源异常", null);
    }

    public ResourcesException(String massage) {
        this(massage, null);
    }

    public ResourcesException(String massage, Throwable throwable) {
        super(massage, throwable);
    }
}
