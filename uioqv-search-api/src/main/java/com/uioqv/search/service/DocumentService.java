package com.uioqv.search.service;

import com.uioqv.search.dto.IndexDocumentDTO;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-24
 */
public interface DocumentService {
    /**
     * 创建一个文档
     * @param indexDocumentDTO
     * @return
     */
    Mono<IndexDocumentDTO> createDocument(IndexDocumentDTO indexDocumentDTO);
}
