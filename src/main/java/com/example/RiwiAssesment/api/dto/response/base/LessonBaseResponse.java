package com.example.RiwiAssesment.api.dto.response.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class LessonBaseResponse {
    private String id;
    private String title;
    private String description;
    private int duration;
}
