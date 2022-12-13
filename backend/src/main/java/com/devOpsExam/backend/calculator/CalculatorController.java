package com.devOpsExam.backend.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/do-math")
public class CalculatorController{
   public final MathOperatorImpl mathOperator;


    @Autowired

    public CalculatorController(MathOperatorImpl mathOperator){
        this.mathOperator = mathOperator;
    }


    @PostMapping
    public double doMath(@RequestBody DoMathRequest mathRequest ) throws InvalidOperationException{
       return mathOperator.doMath(mathRequest);

    }
    @GetMapping
    public String  returnHello(){
        return "Hello";

    }

}
