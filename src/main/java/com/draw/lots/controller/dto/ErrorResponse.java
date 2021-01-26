package com.draw.lots.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.checkerframework.checker.units.qual.A;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ApiError
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonFormat
@Getter
public class ErrorResponse {

    private String message;
    private String errCode;

}