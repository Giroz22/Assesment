package com.example.RiwiAssesment.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String title;

    @Lob
    private String description;
    
    private int duration;

    @ManyToOne
    @JoinColumn(
        name="class_id",
        nullable = false
    )
    private ClassEntity classEntity;

    @OneToMany(
        mappedBy = "lessonEntity",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<MultimediaEntity> multimedia;
}
