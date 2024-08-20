package com.example.RiwiAssesment.infrastructure.abstract_services;

import com.example.RiwiAssesment.api.dto.request.ClassRequest;
import com.example.RiwiAssesment.api.dto.response.ClassResponse;
import com.example.RiwiAssesment.domain.entities.ClassEntity;

public interface IClassService extends IGenericService<ClassEntity,String,ClassRequest,ClassResponse> {
    
}
