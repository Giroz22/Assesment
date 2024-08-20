package com.example.RiwiAssesment.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RiwiAssesment.api.dto.errors.ErrorsResponse;
import com.example.RiwiAssesment.api.dto.response.LessonResponse;
import com.example.RiwiAssesment.infrastructure.services.LessonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/lessons")
@AllArgsConstructor
public class LessonController 
{
    @Autowired
    private LessonService service;

    @Operation(summary = "Retrieves information about a specific resource.")
    @ApiResponse(responseCode = "400", description = "Resource not found.",      
        content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<LessonResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(
            this.service.findById(id)
        );
    }
}
