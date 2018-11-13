package com.uioqv.search.api.handler;

import com.uioqv.base.entity.Result;
import com.uioqv.search.dto.DocumentDTO;
import com.uioqv.search.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-24
 */

@Controller
public class DocumentHandler {
    @Autowired
    private DocumentService documentService;

    /**
     * 保存接口
     * @param request
     * @return
     */
    public Mono<ServerResponse> save(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                documentService.createDocument(request.bodyToMono(DocumentDTO.class))
                        .map(Result::success),
                Result.class
        );
    }

    /**
     * 查询所有接口
     * @param request
     * @return
     */
    public Mono<ServerResponse> find(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(
                documentService.findProject()
                        .map(Result::success),
                Result.class
        );
    }
}
