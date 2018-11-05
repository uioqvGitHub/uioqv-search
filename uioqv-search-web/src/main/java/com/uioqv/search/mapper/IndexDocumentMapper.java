package com.uioqv.search.mapper;

import com.uioqv.search.domain.IndexDocumentDO;
import com.uioqv.search.dto.IndexDocumentDTO;
import com.uioqv.search.mapper.conver.BooleanConver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Mapper(uses = BooleanConver.class)
public interface IndexDocumentMapper {
    IndexDocumentMapper INSTANCE = Mappers.getMapper(IndexDocumentMapper.class);

    IndexDocumentDO dtoToDO(IndexDocumentDTO s);
    IndexDocumentDTO doToDTO(IndexDocumentDO s);
}
