package com.example.RiwiAssesment.infrastructure.helpers.mappers;

import com.example.RiwiAssesment.api.dto.request.ClassRequest;
import com.example.RiwiAssesment.api.dto.response.ClassResponse;
import com.example.RiwiAssesment.api.dto.response.base.LessonBaseResponse;
import com.example.RiwiAssesment.domain.entities.ClassEntity;
import com.example.RiwiAssesment.domain.entities.LessonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T12:31:51-0500",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ClassMapperImpl extends ClassMapper {

    @Autowired
    private LessonMapper lessonMapper;

    @Override
    public ClassResponse entityToResponse(ClassEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ClassResponse.ClassResponseBuilder<?, ?> classResponse = ClassResponse.builder();

        classResponse.active( entity.isActive() );
        classResponse.id( entity.getId() );
        classResponse.instructor( entity.getInstructor() );
        classResponse.title( entity.getTitle() );
        classResponse.lessons( lessonEntityListToLessonBaseResponseList( entity.getLessons() ) );

        return classResponse.build();
    }

    @Override
    public ClassEntity requestToEntity(ClassRequest request) {
        if ( request == null ) {
            return null;
        }

        ClassEntity.ClassEntityBuilder classEntity = ClassEntity.builder();

        classEntity.description( request.getDescription() );
        classEntity.instructor( request.getInstructor() );
        classEntity.title( request.getTitle() );

        return classEntity.build();
    }

    protected List<LessonBaseResponse> lessonEntityListToLessonBaseResponseList(List<LessonEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<LessonBaseResponse> list1 = new ArrayList<LessonBaseResponse>( list.size() );
        for ( LessonEntity lessonEntity : list ) {
            list1.add( lessonMapper.entityToResponse( lessonEntity ) );
        }

        return list1;
    }
}
