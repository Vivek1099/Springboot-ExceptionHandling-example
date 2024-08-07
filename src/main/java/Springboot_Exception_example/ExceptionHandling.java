package Springboot_Exception_example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(IdNotFoundException exception)
    {
        ResponseEntity<Object> entity = new ResponseEntity<>("Id Not Found...!!", HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<Object> handleException(NameNotFoundException exception)
    {
        ResponseEntity<Object> entity = new ResponseEntity<>("Name Not Found...!!", HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(CityNotFoundException.class) // getting message from controller
    public ResponseEntity<Object> handleException(CityNotFoundException exception)
    {
    	String message = exception.getMessage(); //get message from controller class
        return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
