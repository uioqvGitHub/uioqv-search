package com.uioqv.search.mapper;

import com.uioqv.search.domain.DocumentDO;
import com.uioqv.search.dto.DocumentDTO;
import com.uioqv.search.mapper.conver.BooleanConver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Mapper(uses = BooleanConver.class)
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    DocumentDO dtoToDO(DocumentDTO s);
    DocumentDTO doToDTO(DocumentDO s);
}
