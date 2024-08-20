package com.example.RiwiAssesment.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RiwiAssesment.api.dto.errors.ErrorsResponse;
import com.example.RiwiAssesment.api.dto.response.ClassResponse;
import com.example.RiwiAssesment.infrastructure.services.ClassService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/class")
@AllArgsConstructor
public class ClassController 
{
    
    @Autowired
    private ClassService service;

    @Operation(summary = "Retrieves a list of all resources ")
    @ApiResponse(responseCode = "400", description = "Invalid query parameters",      
        content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
        }
    )
    @GetMapping("")
    public ResponseEntity<Page<ClassResponse>> getAll(
        @RequestParam(defaultValue = "") String title,
        @RequestParam(defaultValue = "") String description,
        @RequestParam(defaultValue = "1") int page, 
        @RequestParam(defaultValue = "5") int size
    )
    {
        return ResponseEntity.ok().body(this.service.findAllByNameDescription(title,description,page-1,size));
    }

    @Operation(summary = "Retrieves information about a specific resource.")
    @ApiResponse(responseCode = "400", description = "Resource not found.",      
        content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ClassResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(
            this.service.findById(id)
        );
    }

}
