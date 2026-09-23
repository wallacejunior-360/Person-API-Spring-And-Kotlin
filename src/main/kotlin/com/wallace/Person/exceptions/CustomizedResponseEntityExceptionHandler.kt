package com.wallace.Person.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import java.util.Date

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(e: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse>
    {
        val exceptionResponse = ExceptionResponse(
            Date(),
            e.message ?: "",
            request.getDescription(false),
        )

        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(UnsupportedMathOperationException::class)
    fun handleBadRequestExceptions(e: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse>
    {
        val exceptionResponse = ExceptionResponse(
            Date(),
            e.message ?: "",
            request.getDescription(false),
        )

        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST)
    }
}