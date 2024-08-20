package com.example.RiwiAssesment.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RiwiAssesment.domain.entities.ClassEntity;

@Repository
public interface IClassRepository extends JpaRepository<ClassEntity, String> {
    Page<ClassEntity> findByTitleContainingAndDescriptionContainingAndActiveTrue(String title, String description, Pageable pageable);

}
