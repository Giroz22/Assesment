package com.example.RiwiAssesment.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RiwiAssesment.api.dto.errors.ErrorsResponse;
import com.example.RiwiAssesment.api.dto.response.StudentResponse;
import com.example.RiwiAssesment.infrastructure.services.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@AllArgsConstructor
public class StudentController 
{
    @Autowired
    private StudentService service;

    @Operation(summary = "Retrieves a list of all resources ")
    @ApiResponse(responseCode = "400", description = "Invalid query parameters",      
        content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
        }
    )
    @GetMapping("")
    public ResponseEntity<Page<StudentResponse>> getAll(
        @RequestParam(defaultValue = "") String name,
        @RequestParam(defaultValue = "1") int page, 
        @RequestParam(defaultValue = "5") int size
    )
    {
        return ResponseEntity.ok().body(this.service.findAllByName(name,page-1,size));
    }

    
}