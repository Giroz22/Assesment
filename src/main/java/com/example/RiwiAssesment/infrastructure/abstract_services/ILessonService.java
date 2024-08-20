package com.example.RiwiAssesment.infrastructure.abstract_services;

import com.example.RiwiAssesment.api.dto.request.LessonRequest;
import com.example.RiwiAssesment.api.dto.response.LessonResponse;
import com.example.RiwiAssesment.domain.entities.LessonEntity;

public interface ILessonService extends IGenericService<LessonEntity,String,LessonRequest,LessonResponse>{
    
}
