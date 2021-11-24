package by.tms.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExController {

    @ExceptionHandler(Exception.class)
    public String exception(){
        return "redirect:/oops";
    }
}
