package com.example.RiwiAssesment.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RiwiAssesment.api.dto.request.LessonRequest;
import com.example.RiwiAssesment.api.dto.response.LessonResponse;
import com.example.RiwiAssesment.domain.entities.LessonEntity;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/lessons")
@AllArgsConstructor
public class LessonController extends GenericController<LessonEntity,String,LessonRequest,LessonResponse>{
    
}
