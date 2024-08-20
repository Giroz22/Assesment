package com.example.RiwiAssesment.infrastructure.helpers.mappers;

import com.example.RiwiAssesment.api.dto.request.StudentRequest;
import com.example.RiwiAssesment.api.dto.response.StudentResponse;
import com.example.RiwiAssesment.api.dto.response.base.ClassBaseResponse;
import com.example.RiwiAssesment.domain.entities.ClassEntity;
import com.example.RiwiAssesment.domain.entities.StudentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T13:26:48-0500",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl extends StudentMapper {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public StudentResponse entityToResponse(StudentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        StudentResponse.StudentResponseBuilder<?, ?> studentResponse = StudentResponse.builder();

        studentResponse.active( entity.isActive() );
        studentResponse.createAt( entity.getCreateAt() );
        studentResponse.email( entity.getEmail() );
        studentResponse.id( entity.getId() );
        studentResponse.name( entity.getName() );
        studentResponse.classes( classEntityListToClassBaseResponseList( entity.getClasses() ) );

        return studentResponse.build();
    }

    @Override
    public StudentEntity requestToEntity(StudentRequest request) {
        if ( request == null ) {
            return null;
        }

        StudentEntity.StudentEntityBuilder studentEntity = StudentEntity.builder();

        studentEntity.email( request.getEmail() );
        studentEntity.name( request.getName() );

        return studentEntity.build();
    }

    protected List<ClassBaseResponse> classEntityListToClassBaseResponseList(List<ClassEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ClassBaseResponse> list1 = new ArrayList<ClassBaseResponse>( list.size() );
        for ( ClassEntity classEntity : list ) {
            list1.add( classMapper.entityToResponse( classEntity ) );
        }

        return list1;
    }
}
