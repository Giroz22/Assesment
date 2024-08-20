package com.example.RiwiAssesment.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.RiwiAssesment.api.dto.request.StudentRequest;
import com.example.RiwiAssesment.api.dto.response.StudentResponse;
import com.example.RiwiAssesment.domain.entities.StudentEntity;
import com.example.RiwiAssesment.domain.repositories.IStudentRepository;
import com.example.RiwiAssesment.infrastructure.abstract_services.IStudentService;
import com.example.RiwiAssesment.infrastructure.helpers.mappers.StudentMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService
    extends GenericService<StudentEntity,String,StudentRequest,StudentResponse>
    implements IStudentService
{

    @Autowired
    private IStudentRepository repository;

    @Autowired
    private StudentMapper mapper;

    public Page<StudentResponse> findAllByName(String name, int page, int size) {

        if (page<0) page = 0;

        PageRequest pagination = PageRequest.of(page, size); 

        return this.repository.findByNameContainingAndActiveTrue(name, pagination).map((entity) ->
            this.mapper.entityToResponse(entity)
        );
    }
    
}
