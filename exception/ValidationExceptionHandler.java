//package com.example.assess.exception;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import com.example.assess.response.ResponseGenerator;
//
//@ControllerAdvice
//public class ValidationExceptionHandler {
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
//		Map<String, String> fieldErrors = new LinkedHashMap<>();
//
//		ex.getBindingResult().getFieldErrors().forEach(error -> {
//			fieldErrors.putIfAbsent(error.getField(), error.getDefaultMessage());
//		});
//
//		String combinedErrors = fieldErrors.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue())
//				.collect(Collectors.joining(", "));
//
//		return ResponseGenerator.failureResponse("Validation failed: " + combinedErrors);
//	}
//}
