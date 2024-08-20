package com.example.RiwiAssesment.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String title;

    @Lob
    private String description;

    @Column(nullable = false)
    private String instructor;
    
    private boolean active;

    @OneToMany(
        mappedBy = "classEntity",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<LessonEntity> lessons;

    @ManyToMany(mappedBy = "classes")
    private List<StudentEntity> students;
}
