package com.example.RiwiAssesment.infrastructure.abstract_services;

import com.example.RiwiAssesment.api.dto.request.MultimediaRequest;
import com.example.RiwiAssesment.api.dto.response.base.MultimediaBaseResponse;
import com.example.RiwiAssesment.domain.entities.MultimediaEntity;

public interface IMultimediaService 
    extends IGenericService<MultimediaEntity,String,MultimediaRequest,MultimediaBaseResponse>{
    
}
