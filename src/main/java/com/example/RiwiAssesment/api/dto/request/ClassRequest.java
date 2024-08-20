package com.example.RiwiAssesment.api.dto.request;

import jakarta.validation.constraints.NotNull;
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
public class ClassRequest {

    @NotNull(message = "The title is required")    
    private String title;

    @Size(
        max = 300,
        message = "description cannot be longer than 300 characters"
    )
    private String description;

    @NotNull(message = "The name of instructor is required")    
    private String instructor;
    
}
