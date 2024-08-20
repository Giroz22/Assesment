package com.example.RiwiAssesment.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RiwiAssesment.api.dto.request.ClassRequest;
import com.example.RiwiAssesment.api.dto.response.ClassResponse;
import com.example.RiwiAssesment.domain.entities.ClassEntity;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/class")
@AllArgsConstructor
public class ClassController 
    extends GenericController<ClassEntity,String,ClassRequest,ClassResponse>
{
    
}
