package com.example.RiwiAssesment.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RiwiAssesment.api.dto.request.LessonRequest;
import com.example.RiwiAssesment.api.dto.response.LessonResponse;
import com.example.RiwiAssesment.domain.entities.ClassEntity;
import com.example.RiwiAssesment.domain.entities.LessonEntity;
import com.example.RiwiAssesment.domain.entities.MultimediaEntity;
import com.example.RiwiAssesment.domain.repositories.ILessonRepository;
import com.example.RiwiAssesment.domain.repositories.IMultimediaRepository;
import com.example.RiwiAssesment.infrastructure.abstract_services.ILessonService;
import com.example.RiwiAssesment.infrastructure.helpers.mappers.LessonMapper;
import com.example.RiwiAssesment.infrastructure.helpers.mappers.MultimediaMapper;
import com.example.RiwiAssesment.util.exceptions.IdNotFoundException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService
    extends GenericService<LessonEntity,String,LessonRequest,LessonResponse>
    implements ILessonService
{

    @Autowired
    private ILessonRepository repository;

    @Autowired
    private IMultimediaRepository multimediaRepository;

    @Autowired
    private ClassService classService;

    @Autowired
    private LessonMapper mapper;

    @Autowired
    private MultimediaMapper multimediaMapper;

    @Override
    @Transactional
    public LessonResponse create(LessonRequest request) {
        LessonEntity lessonEntity = this.mapper.requestToEntity(request); 

        ClassEntity classEntity = classService.find(request.getId_class()); 
        if(!classEntity.isActive()) new IdNotFoundException("Class");   

        lessonEntity.setClassEntity(classEntity);        
        lessonEntity.setMultimedia(new ArrayList<>());

        LessonEntity lessonSaved = this.repository.save(lessonEntity);

        List<MultimediaEntity> multimedia = multimediaMapper.listRQtoListE(request.getMultimedia()); 

        multimedia.forEach((MultimediaEntity media) -> {
            media.setLessonEntity(lessonSaved);
            MultimediaEntity mediaSaved = this.multimediaRepository.save(media);
            lessonSaved.getMultimedia().add(mediaSaved) ;
        });

        return this.mapper.entityToResponse(lessonSaved);
    }
}
