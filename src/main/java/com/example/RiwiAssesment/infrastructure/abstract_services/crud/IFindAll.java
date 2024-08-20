package com.example.RiwiAssesment.infrastructure.abstract_services.crud;

import org.springframework.data.domain.Page;

public interface IFindAll<RS> {
    public Page<RS> findAll(int page, int size);    
}
