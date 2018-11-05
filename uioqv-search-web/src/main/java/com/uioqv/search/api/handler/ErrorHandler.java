//package com.uioqv.search.api.handler;
//
//import com.uioqv.search.Result;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebExceptionHandler;
//import reactor.core.publisher.Mono;
//
///**
// * @author LiuGuoQing
// * @since 2018-10-25
// */
//@Controller
//public class ErrorHandler implements WebExceptionHandler {
//
////    @ExceptionHandler(Exception.class)
////    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
////    public ResponseEntity<Result> hadleServerException(Exception exception) {
////        String msg = "系统错误";
////        if(StringUtils.isNoneBlank(exception.getMessage())) {
////            msg = exception.getMessage();
////        }
////        return new ResponseEntity(Result.failure(msg), HttpStatus.INTERNAL_SERVER_ERROR);
////    }
//
//    @Override
//    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
//        String msg = "系统错误";
//        if(StringUtils.isNoneBlank(throwable.getMessage())) {
//            msg = throwable.getMessage();
//        }
//        return Mono.error();
//    }
//}
