package com.reservas.reservas.infrastructure.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    int httpCode;
    String url;
    String httpMethod;
    String message;
    String backendMessage;
    LocalDateTime timestamp;
    List<String> details;
}