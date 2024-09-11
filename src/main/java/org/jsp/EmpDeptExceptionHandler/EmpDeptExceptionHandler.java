package org.jsp.EmpDeptExceptionHandler;

import org.jsp.Entity.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmpDeptExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleINFE(IdNotFoundException exception){
		ResponseStructure<String>structure=new ResponseStructure<>();
		structure.setData("id not found");
		structure.setMessage(exception.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseStructure<String>> handleINCE(InvalidCredentialsException exception){
		ResponseStructure<String>structure=new ResponseStructure<>();
		structure.setData("invalid credentials");
		structure.setMessage(exception.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	

}
