package io.github.tsrangel.mscreditcard.application.exceptionHandler;

import io.github.tsrangel.mscreditcard.application.exceptionHandler.errors.FieldValidationError;
import io.github.tsrangel.mscreditcard.application.exceptionHandler.errors.StandartError;
import io.github.tsrangel.mscreditcard.application.services.exceptions.ResourceAlreadyExistsException;
import io.github.tsrangel.mscreditcard.application.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ControllersExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandartError> standartError(HttpServletRequest request, RuntimeException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(status.value())
                .body(new StandartError(
                        status.value(),
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<StandartError> alreadyExistsError(HttpServletRequest request,
                                                            ResourceAlreadyExistsException e) {
        HttpStatus status = HttpStatus.CONFLICT;
        return ResponseEntity
                .status(status.value())
                .body(new StandartError(
                        status.value(),
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> notFoundError(HttpServletRequest request, ResourceNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity
                .status(status)
                .body(new StandartError(
                        status.value(),
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FieldValidationError> fieldValidatorError(HttpServletRequest request,
                                                                    MethodArgumentNotValidException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        HashMap<String, String> errors = new HashMap<>();

        e.getFieldErrors().
                forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.status(status).body(new FieldValidationError(
                status.value(),
                "Erro de validação dos campos.",
                errors
        ));
    }
}
