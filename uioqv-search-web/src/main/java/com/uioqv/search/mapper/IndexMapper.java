package com.uioqv.search.mapper;

import com.uioqv.search.domain.IndexDO;
import com.uioqv.search.dto.IndexDTO;
import com.uioqv.search.mapper.conver.BooleanConver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Mapper(uses = BooleanConver.class)
public interface IndexMapper {
    IndexMapper INSTANCE = Mappers.getMapper(IndexMapper.class);

    IndexDO dtoToDO(IndexDTO s);
    IndexDTO doToDTO(IndexDO s);
}
