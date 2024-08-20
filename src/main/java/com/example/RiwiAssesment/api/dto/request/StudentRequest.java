package com.example.RiwiAssesment.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
public class StudentRequest {
    @NotNull(message = "The url is required")    
    private String name;

    @NotNull(message = "The url is required")    
    @Email(message = "The email is invalid")
    private String email;
}
