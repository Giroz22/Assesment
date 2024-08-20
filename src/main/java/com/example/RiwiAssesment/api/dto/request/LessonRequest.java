package com.example.RiwiAssesment.api.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LessonRequest {    

    @NotNull(message = "The title is required")    
    private String title;

    @Size(
        max = 300,
        message = "Description cannot be longer than 300 characters"
    )
    private String description;
    
    @Positive(message = "The duration must contain positive numbers")
    private int duration;

    private List<MultimediaRequest> multimedia;

    private String id_class;
}
