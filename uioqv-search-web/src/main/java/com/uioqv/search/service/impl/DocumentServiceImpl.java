package com.uioqv.search.service.impl;

import com.uioqv.search.dto.IndexDocumentDTO;
import com.uioqv.search.mapper.IndexDocumentMapper;
import com.uioqv.search.repostory.IndexDocumentRepository;
import com.uioqv.search.service.DocumentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author LiuGuoQing
 * @since 2018-10-24
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private IndexDocumentRepository documentRepository;

    @Override
    public Mono<IndexDocumentDTO> createDocument(IndexDocumentDTO indexDocumentDTO) {
        return documentRepository.save(IndexDocumentMapper.INSTANCE.dtoToDO(indexDocumentDTO))
                .filter((e) -> { return StringUtils.isNoneBlank(e.getId()); })
                .single()
                .map(IndexDocumentMapper.INSTANCE::doToDTO);
    }
}
