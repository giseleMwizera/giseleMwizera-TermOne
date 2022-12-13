package com.devOpsExam.backend.calculator;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class InvalidOperationException extends Exception{
   public InvalidOperationException(String message){
       super(message);

   }
}
