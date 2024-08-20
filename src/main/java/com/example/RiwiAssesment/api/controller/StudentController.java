package com.example.RiwiAssesment.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RiwiAssesment.api.dto.errors.ErrorsResponse;
import com.example.RiwiAssesment.api.dto.request.StudentRequest;
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

    @Operation(summary = "Creates a new resource")
    @ApiResponse(responseCode = "400", description = "Incorrect or missing input data.",      
        content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
        }
    )
    @PostMapping("")
    public ResponseEntity<StudentResponse> create(@Validated @RequestBody StudentRequest request) {
        return ResponseEntity.ok().body(this.service.create(request));
    }

    @Operation(summary = "Retrieves information about a specific resource.")
    @ApiResponse(responseCode = "400", description = "Resource not found.",      
        content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(
            this.service.findById(id)
        );
    }

    @GetMapping("/{id}/disable")
    public ResponseEntity<StudentResponse> disable(@PathVariable String id) {
        return ResponseEntity.ok().body(
            this.service.disable(id)
        );
    }
    
    @Operation(summary = "Updates information about a specific resource.")
    @ApiResponse(responseCode = "400", description = "Incorrect or missing input data.",      
        content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable String id, @Validated @RequestBody StudentRequest request) {    
        return ResponseEntity.ok().body(this.service.update(id, request));
    }
}
