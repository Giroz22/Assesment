package com.example.RiwiAssesment.api.dto.response;

import java.util.List;

import com.example.RiwiAssesment.api.dto.response.base.ClassBaseResponse;
import com.example.RiwiAssesment.api.dto.response.base.StudentBaseResponse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class StudentResponse extends StudentBaseResponse{
    private List<ClassBaseResponse> classes; 
}