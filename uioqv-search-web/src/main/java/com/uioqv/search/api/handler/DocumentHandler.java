package com.uioqv.search.api.handler;

import com.uioqv.search.dto.IndexDocumentDTO;
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

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(
                serverRequest.bodyToMono(IndexDocumentDTO.class).flatMap(
                        documentService::createDocument
                ), IndexDocumentDTO.class
        );
    }
}
