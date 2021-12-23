package com.switchfully.goatpark.api;

import com.switchfully.goatpark.exception.NotExistingDivisionException;
import com.switchfully.goatpark.exception.NotUniqueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler (NotUniqueException.class)
    protected void notUniqueException(NotUniqueException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler (NotExistingDivisionException.class)
    protected void notExistingDivisionException(NotExistingDivisionException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler (Exception.class)
    protected void exceptionHandling(Exception ex, HttpServletResponse response) throws IOException {
        logger.error(ex.getMessage());
        response.sendError(response.getStatus(), ex.getMessage());
    }

}
