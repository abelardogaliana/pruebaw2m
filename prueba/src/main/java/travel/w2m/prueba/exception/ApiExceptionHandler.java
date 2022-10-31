package travel.w2m.prueba.exception;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleException2(RecordNotFoundException ex) {
		StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse(ex.getClass().getCanonicalName(),"No ha encontrado superheroes",
				"error-2", ex.getMessage());
		return new ResponseEntity<StandarizedApiExceptionResponse>(response, HttpStatus.PARTIAL_CONTENT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleException(Exception ex) {
		StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse(ex.getClass().getCanonicalName(),"Error general",
				"error-1", ex.getMessage());
		return new ResponseEntity<StandarizedApiExceptionResponse>(response, HttpStatus.PARTIAL_CONTENT);
	}
	
	@ExceptionHandler(InvalidDataAccessResourceUsageException.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleException(InvalidDataAccessResourceUsageException ex) {
		StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse(ex.getClass().getCanonicalName(),"Error al insertar un Objeto en la BD",
				"error-3", ex.getMessage());
		return new ResponseEntity<StandarizedApiExceptionResponse>(response, HttpStatus.PARTIAL_CONTENT);
	}
	
	

}
