package com.example.RiwiAssesment.api.dto.response.base;

import com.example.RiwiAssesment.util.enums.TypeMultimedia;

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
public class MultimediaBaseResponse {
    private String id;
    private TypeMultimedia type;
    private String url;
    private String title;
    private String description;
}
