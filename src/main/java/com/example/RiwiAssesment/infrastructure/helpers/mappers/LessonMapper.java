package com.example.RiwiAssesment.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.RiwiAssesment.api.dto.request.LessonRequest;
import com.example.RiwiAssesment.api.dto.response.LessonResponse;
import com.example.RiwiAssesment.domain.entities.LessonEntity;

@Mapper(componentModel = "spring", uses = {MultimediaMapper.class})
public abstract class LessonMapper implements IMapperBase<LessonEntity,LessonRequest,LessonResponse>{

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "classEntity", ignore = true)
    public abstract LessonEntity requestToEntity(LessonRequest request);
    
}
