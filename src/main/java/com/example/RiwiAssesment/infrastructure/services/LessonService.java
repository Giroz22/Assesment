package com.example.RiwiAssesment.infrastructure.services;

import org.springframework.stereotype.Service;

import com.example.RiwiAssesment.api.dto.request.LessonRequest;
import com.example.RiwiAssesment.api.dto.response.LessonResponse;
import com.example.RiwiAssesment.domain.entities.LessonEntity;
import com.example.RiwiAssesment.infrastructure.abstract_services.ILessonService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService
    extends GenericService<LessonEntity,String,LessonRequest,LessonResponse>
    implements ILessonService
{
    
}
