package com.uioqv.search.mapper;

import com.uioqv.search.domain.IndexCreateDO;
import com.uioqv.search.dto.IndexCreateDTO;
import com.uioqv.search.mapper.conver.BooleanConver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Mapper(uses = BooleanConver.class)
public interface IndexCreateMapper {
    IndexCreateMapper INSTANCE = Mappers.getMapper(IndexCreateMapper.class);

    IndexCreateDO dtoToDO(IndexCreateDTO s);
    IndexCreateDTO doToDTO(IndexCreateDO s);
}
