package com.uioqv.search.service;

import com.uioqv.search.dto.IndexDTO;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
public interface IndexCreateService {
    /**
     * 创建一个索引
     * @param indexMono
     * @return
     */
    Mono<IndexDTO> createDocument(Mono<IndexDTO> indexMono);
}
