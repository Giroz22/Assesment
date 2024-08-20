package com.example.RiwiAssesment.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.RiwiAssesment.api.dto.request.ClassRequest;
import com.example.RiwiAssesment.api.dto.response.ClassResponse;
import com.example.RiwiAssesment.domain.entities.ClassEntity;

@Mapper(componentModel = "spring", uses = {LessonMapper.class})
public abstract class ClassMapper implements IMapperBase<ClassEntity,ClassRequest,ClassResponse>{

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    @Mapping(target = "active", ignore = true)
    public abstract ClassEntity requestToEntity(ClassRequest request);
    
}
