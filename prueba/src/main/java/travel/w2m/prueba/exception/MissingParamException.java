package travel.w2m.prueba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingParamException extends Exception {

	private static final long serialVersionUID = 1L;

	public MissingParamException() {
		
	}
}
