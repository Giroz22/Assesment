package com.example.RiwiAssesment.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.RiwiAssesment.api.dto.request.StudentRequest;
import com.example.RiwiAssesment.api.dto.response.StudentResponse;
import com.example.RiwiAssesment.domain.entities.StudentEntity;

@Mapper(componentModel = "spring", uses = {ClassMapper.class})
public abstract class StudentMapper implements IMapperBase<StudentEntity,StudentRequest,StudentResponse>{

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "classes", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    public abstract StudentEntity requestToEntity(StudentRequest request);
    
}
