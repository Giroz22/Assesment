package com.example.RiwiAssesment.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RiwiAssesment.domain.entities.MultimediaEntity;

@Repository
public interface IMultimediaRepository extends JpaRepository<MultimediaEntity, String>{
    
}
