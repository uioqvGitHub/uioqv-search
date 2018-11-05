package com.uioqv.search.mapper;

import com.uioqv.search.domain.IndexFieldDO;
import com.uioqv.search.dto.IndexFieldDTO;
import com.uioqv.search.mapper.conver.BooleanConver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Mapper(uses = BooleanConver.class)
public interface IndexFieldMapper {
    IndexFieldMapper INSTANCE = Mappers.getMapper(IndexFieldMapper.class);

    IndexFieldDO dtoToDO(IndexFieldDTO s);
    IndexFieldDTO doToDTO(IndexFieldDO s);
}
