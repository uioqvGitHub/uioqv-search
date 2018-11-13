package com.uioqv.search.service;

import com.uioqv.search.dto.DocumentDTO;
import com.uioqv.search.qto.DocumentQO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-24
 */
public interface DocumentService {

    /**
     * 创建一个文档
     * @param documentMono
     * @return
     */
    Mono<DocumentDTO> createDocument(Mono<DocumentDTO> documentMono);

    /**
     * 查询文档
     * @param documentQO
     * @return
     */
    Flux<DocumentDTO> findDocument(Mono<DocumentQO> documentQO);
}
