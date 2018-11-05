package com.uioqv.search.mapper;

import com.uioqv.search.domain.ProjectDO;
import com.uioqv.search.dto.ProjectDTO;
import com.uioqv.search.mapper.conver.BooleanConver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Mapper(uses = BooleanConver.class)
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDO dtoToDO(ProjectDTO s);
    ProjectDTO doToDTO(ProjectDO s);
}
