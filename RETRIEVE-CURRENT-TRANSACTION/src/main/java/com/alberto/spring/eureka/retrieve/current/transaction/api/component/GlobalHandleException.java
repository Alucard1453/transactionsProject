package com.alberto.spring.eureka.retrieve.current.transaction.api.component;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alberto.spring.eureka.retrieve.current.transaction.api.exceptions.ErrorResponse;
import com.alberto.spring.eureka.retrieve.current.transaction.api.exceptions.custom.EmptyFieldException;
import com.alberto.spring.eureka.retrieve.current.transaction.api.exceptions.custom.InvalidFieldException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalHandleException{
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ErrorResponse.class);
	
	@ExceptionHandler(EmptyFieldException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	ErrorResponse handleEmptyFieldException(EmptyFieldException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setType(ex.getErrorType());
		errorResponse.setCode(ex.getErrorCode());
		errorResponse.setLocation(ex.getStackTrace()[0]);
		errorResponse.setMoreInfo(ex.getMessage());
		
		GlobalHandleException.writeToLog(errorResponse, ex);
		
		return errorResponse;
	}
	
	@ExceptionHandler(InvalidFieldException.class)
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
	@ResponseBody
	ErrorResponse handleInvalidFieldException(InvalidFieldException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setType(ex.getErrorType());
		errorResponse.setCode(ex.getErrorCode());
		errorResponse.setLocation(ex.getStackTrace()[0]);
		errorResponse.setMoreInfo(ex.getMessage());
		
		GlobalHandleException.writeToLog(errorResponse, ex);
		
		return errorResponse;
	}
	
	public static void writeToLog(ErrorResponse errorResponse, Exception ex){
		log.error(errorResponse.toString());
		log.error(ex.toString());
	}
}
