package com.example.RiwiAssesment.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.RiwiAssesment.api.dto.request.ClassRequest;
import com.example.RiwiAssesment.api.dto.response.ClassResponse;
import com.example.RiwiAssesment.domain.entities.ClassEntity;
import com.example.RiwiAssesment.domain.repositories.IClassRepository;
import com.example.RiwiAssesment.infrastructure.abstract_services.IClassService;
import com.example.RiwiAssesment.infrastructure.helpers.mappers.ClassMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService 
    extends GenericService<ClassEntity,String,ClassRequest,ClassResponse>
    implements IClassService
{

    @Autowired
    private IClassRepository repository;

    @Autowired
    private ClassMapper mapper;

    public Page<ClassResponse> findAllByNameDescription(String title, String description,int page, int size) {

        if (page<0) page = 0;

        PageRequest pagination = PageRequest.of(page, size); 

        return this.repository.findByTitleContainingAndDescriptionContainingAndActiveTrue(title, description, pagination).map((entity) ->
            this.mapper.entityToResponse(entity)
        );
    }
}
