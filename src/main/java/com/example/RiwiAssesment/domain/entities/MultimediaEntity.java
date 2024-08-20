package com.example.RiwiAssesment.domain.entities;

import com.example.RiwiAssesment.util.enums.TypeMultimedia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "multimedia")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MultimediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private TypeMultimedia type;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String title;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(
        name="lesson_id",
        nullable = false
    )
    private LessonEntity lessonEntity;
}
