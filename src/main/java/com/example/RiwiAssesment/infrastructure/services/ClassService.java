package com.example.RiwiAssesment.infrastructure.services;

import org.springframework.stereotype.Service;

import com.example.RiwiAssesment.api.dto.request.ClassRequest;
import com.example.RiwiAssesment.api.dto.response.ClassResponse;
import com.example.RiwiAssesment.domain.entities.ClassEntity;
import com.example.RiwiAssesment.infrastructure.abstract_services.IClassService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService 
    extends GenericService<ClassEntity,String,ClassRequest,ClassResponse>
    implements IClassService
{
    
}
