package com.example.RiwiAssesment.api.dto.request;

import com.example.RiwiAssesment.util.enums.TypeMultimedia;

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
public class MultimediaRequest {

    private TypeMultimedia type;

    @NotNull(message = "The url is required")    
    private String url;

    @NotNull(message = "The title is required")    
    private String title;

    @Size(
        max = 300,
        message = "Description cannot be longer than 300 characters"
    )
    private String description;
}
