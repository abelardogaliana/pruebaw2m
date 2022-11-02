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
		return new ResponseEntity<StandarizedApiExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleException(Exception ex) {
		StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse(ex.getClass().getCanonicalName(),"Error general",
				"error-1", ex.getMessage());
		return new ResponseEntity<StandarizedApiExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidDataAccessResourceUsageException.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleException3(InvalidDataAccessResourceUsageException ex) {
		StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse(ex.getClass().getCanonicalName(),"Error al insertar un Objeto en la BD",
				"error-3", ex.getMessage());
		return new ResponseEntity<StandarizedApiExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingParamException.class)
	public ResponseEntity<StandarizedApiExceptionResponse> handleException4(MissingParamException ex) {
		StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse(ex.getClass().getCanonicalName(),"Faltan Parametros en el request",
				"error-4", ex.getMessage());
		return new ResponseEntity<StandarizedApiExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	
	

}
