package com.example.RiwiAssesment.infrastructure.helpers.mappers;

import com.example.RiwiAssesment.api.dto.request.LessonRequest;
import com.example.RiwiAssesment.api.dto.response.LessonResponse;
import com.example.RiwiAssesment.api.dto.response.base.ClassBaseResponse;
import com.example.RiwiAssesment.api.dto.response.base.MultimediaBaseResponse;
import com.example.RiwiAssesment.domain.entities.ClassEntity;
import com.example.RiwiAssesment.domain.entities.LessonEntity;
import com.example.RiwiAssesment.domain.entities.MultimediaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T14:15:57-0500",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class LessonMapperImpl extends LessonMapper {

    @Autowired
    private MultimediaMapper multimediaMapper;

    @Override
    public LessonResponse entityToResponse(LessonEntity entity) {
        if ( entity == null ) {
            return null;
        }

        LessonResponse.LessonResponseBuilder<?, ?> lessonResponse = LessonResponse.builder();

        lessonResponse.description( entity.getDescription() );
        lessonResponse.duration( entity.getDuration() );
        lessonResponse.id( entity.getId() );
        lessonResponse.title( entity.getTitle() );
        lessonResponse.classEntity( classEntityToClassBaseResponse( entity.getClassEntity() ) );
        lessonResponse.multimedia( multimediaEntityListToMultimediaBaseResponseList( entity.getMultimedia() ) );

        return lessonResponse.build();
    }

    @Override
    public LessonEntity requestToEntity(LessonRequest request) {
        if ( request == null ) {
            return null;
        }

        LessonEntity.LessonEntityBuilder lessonEntity = LessonEntity.builder();

        lessonEntity.description( request.getDescription() );
        lessonEntity.duration( request.getDuration() );
        lessonEntity.multimedia( multimediaMapper.listRQtoListE( request.getMultimedia() ) );
        lessonEntity.title( request.getTitle() );

        return lessonEntity.build();
    }

    protected ClassBaseResponse classEntityToClassBaseResponse(ClassEntity classEntity) {
        if ( classEntity == null ) {
            return null;
        }

        ClassBaseResponse.ClassBaseResponseBuilder<?, ?> classBaseResponse = ClassBaseResponse.builder();

        classBaseResponse.active( classEntity.isActive() );
        classBaseResponse.id( classEntity.getId() );
        classBaseResponse.instructor( classEntity.getInstructor() );
        classBaseResponse.title( classEntity.getTitle() );

        return classBaseResponse.build();
    }

    protected List<MultimediaBaseResponse> multimediaEntityListToMultimediaBaseResponseList(List<MultimediaEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<MultimediaBaseResponse> list1 = new ArrayList<MultimediaBaseResponse>( list.size() );
        for ( MultimediaEntity multimediaEntity : list ) {
            list1.add( multimediaMapper.entityToResponse( multimediaEntity ) );
        }

        return list1;
    }
}
