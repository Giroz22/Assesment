package com.example.RiwiAssesment.infrastructure.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.RiwiAssesment.api.dto.request.StudentRequest;
import com.example.RiwiAssesment.api.dto.response.StudentResponse;
import com.example.RiwiAssesment.domain.entities.ClassEntity;
import com.example.RiwiAssesment.domain.entities.StudentEntity;
import com.example.RiwiAssesment.domain.repositories.IStudentRepository;
import com.example.RiwiAssesment.infrastructure.abstract_services.IStudentService;
import com.example.RiwiAssesment.infrastructure.helpers.mappers.StudentMapper;
import com.example.RiwiAssesment.util.exceptions.IdNotFoundException;

import jakarta.transaction.Transactional;
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
    private ClassService classService;

    @Autowired
    private StudentMapper mapper;

    public Page<StudentResponse> findAllByName(String name, int page, int size) {

        if (page<0) page = 0;

        PageRequest pagination = PageRequest.of(page, size); 

        return this.repository.findByNameContainingAndActiveTrue(name, pagination).map((entity) ->
            this.mapper.entityToResponse(entity)
        );
    }

    @Override
    @Transactional
    public StudentResponse create(StudentRequest request) {

        ClassEntity classEntity = classService.find(request.getIdClass());
        if(!classEntity.isActive()) new IdNotFoundException("Class"); 

        StudentEntity studentEntity = this.mapper.requestToEntity(request);  
        studentEntity.setActive(true);
        studentEntity.setCreateAt(LocalDateTime.now());   
        studentEntity.setClasses(new ArrayList<>()); 

        studentEntity.getClasses().add(classEntity);
        
        StudentEntity entitySaved = this.repository.save(studentEntity);

        return this.mapper.entityToResponse(entitySaved);
    }

    public StudentResponse disable(String id) {
        
        StudentEntity enitity = this.find(id);
        enitity.setActive(false);
        
        StudentEntity studentDisabled = this.repository.save(enitity);

        return this.mapper.entityToResponse(studentDisabled);
    }
    
    @Override
    @Transactional
    public StudentResponse update(String id, StudentRequest request) {
        StudentEntity entity = this.find(id);
        if(!entity.isActive()) new IdNotFoundException("Student"); 

        StudentEntity entityRequest = this.mapper.requestToEntity(request);

        BeanUtils.copyProperties(entityRequest, entity, "id");

        StudentEntity voucherUpdated = this.repository.save(entity);

        return this.mapper.entityToResponse(voucherUpdated);

    }
}
