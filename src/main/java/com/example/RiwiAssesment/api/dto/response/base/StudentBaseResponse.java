package com.example.RiwiAssesment.api.dto.response.base;

import java.time.LocalDateTime;

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
public class StudentBaseResponse {
    private String id; 
    private String name;
    private String email;
    private LocalDateTime createAt;
    private boolean active;
}
