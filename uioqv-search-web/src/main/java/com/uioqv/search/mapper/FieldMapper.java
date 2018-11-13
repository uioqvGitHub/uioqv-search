package com.uioqv.search.mapper;

import com.uioqv.search.domain.FieldDO;
import com.uioqv.search.dto.FieldDTO;
import com.uioqv.search.mapper.conver.BooleanConver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Mapper(uses = BooleanConver.class)
public interface FieldMapper {
    FieldMapper INSTANCE = Mappers.getMapper(FieldMapper.class);

    FieldDO dtoToDO(FieldDTO s);
    FieldDTO doToDTO(FieldDO s);
}
