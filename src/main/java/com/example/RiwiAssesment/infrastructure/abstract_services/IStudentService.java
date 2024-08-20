package com.example.RiwiAssesment.infrastructure.abstract_services;

import com.example.RiwiAssesment.api.dto.request.StudentRequest;
import com.example.RiwiAssesment.api.dto.response.StudentResponse;
import com.example.RiwiAssesment.domain.entities.StudentEntity;

public interface IStudentService extends IGenericService<StudentEntity, String, StudentRequest, StudentResponse>{
    
}
