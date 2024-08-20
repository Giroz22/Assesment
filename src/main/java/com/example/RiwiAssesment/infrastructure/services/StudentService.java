package com.example.RiwiAssesment.infrastructure.services;

import org.springframework.stereotype.Service;

import com.example.RiwiAssesment.api.dto.request.StudentRequest;
import com.example.RiwiAssesment.api.dto.response.StudentResponse;
import com.example.RiwiAssesment.domain.entities.StudentEntity;
import com.example.RiwiAssesment.infrastructure.abstract_services.IStudentService;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService
    extends GenericService<StudentEntity,String,StudentRequest,StudentResponse>
    implements IStudentService
{
    
}
