package com.example.RiwiAssesment.infrastructure.services;

import org.springframework.stereotype.Service;

import com.example.RiwiAssesment.api.dto.request.MultimediaRequest;
import com.example.RiwiAssesment.api.dto.response.base.MultimediaBaseResponse;
import com.example.RiwiAssesment.domain.entities.MultimediaEntity;
import com.example.RiwiAssesment.infrastructure.abstract_services.IMultimediaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MultimediaService
    extends GenericService<MultimediaEntity,String,MultimediaRequest,MultimediaBaseResponse>
    implements IMultimediaService
{
    
}
