package com.example.RiwiAssesment.api.dto.response.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class ClassBaseResponse {
    private String id;
    private String title;
    private String instructor;
    private boolean active;
}
