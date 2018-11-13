package com.uioqv.search.api.router;

import com.uioqv.search.api.handler.DocumentHandler;
import com.uioqv.search.api.handler.ProjectHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.http.MediaType.*;

import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author LiuGuoQing
 * @since 2018-10-24
 */
@Configuration
public class RouteConfig {
    @Autowired
    private DocumentHandler documentHandler;
    @Autowired
    private ProjectHandler projectHandler;

    /**
     * 文档服务
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> document() {
        return route( POST("/documents"), documentHandler::save )
                .andRoute( GET("/documents"), documentHandler::find);
    }

    /**
     * 项目服务
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> project() {
        return route( POST("/projects"), projectHandler::save )
                .andRoute( GET("/projects"), projectHandler::find );
    }



}
