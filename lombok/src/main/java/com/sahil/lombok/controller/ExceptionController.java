package com.sahil.lombok.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice  now we don't require this annotation as we are hadling it using @Responsestatus
public class ExceptionController {
//	@ExceptionHandler( NotFoundException.class)
//	public ResponseEntity handleNotFoundExpection() {
//		return ResponseEntity.notFound().build();
//	}

}
