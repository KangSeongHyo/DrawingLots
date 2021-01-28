package com.draw.lots.controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

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