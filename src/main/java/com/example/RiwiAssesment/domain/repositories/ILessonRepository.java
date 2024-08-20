package com.example.RiwiAssesment.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RiwiAssesment.domain.entities.LessonEntity;

@Repository
public interface ILessonRepository extends JpaRepository<LessonEntity, String> {
    
}
