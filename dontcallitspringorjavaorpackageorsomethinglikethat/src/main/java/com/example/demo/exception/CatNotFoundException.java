package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="no cat found with that id")
public class CatNotFoundException extends RuntimeException  {

	private static final long serialVersionUID = -4394664582994780611L;
	
}
