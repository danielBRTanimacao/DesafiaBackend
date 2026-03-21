package daniel.Desafia.utils.exceptions;

import daniel.Desafia.utils.customs.AlreadyExistException;
import daniel.Desafia.utils.customs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class WorkExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Internal server error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> onValidationError(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err ->
                errors.put(err.getField(), err.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<Map<String, String>> alreadyExist(AlreadyExistException cause) {
        Map<String, String> error = new HashMap<>();
        error.put("error", cause.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> notFound(NotFoundException cause) {
        Map<String, String> error = new HashMap<>();
        error.put("error", cause.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> onIllegalArgument(IllegalArgumentException cause) {
        Map<String, String> error = new HashMap<>();
        error.put("error", cause.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
