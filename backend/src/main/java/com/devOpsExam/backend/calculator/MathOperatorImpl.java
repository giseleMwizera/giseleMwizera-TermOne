package com.devOpsExam.backend.calculator;

import org.springframework.stereotype.Service;

@Service
public class MathOperatorImpl implements MathOperator{

    @Override
    public double doMath(DoMathRequest mathRequest) throws InvalidOperationException {
        if("/".equals(mathRequest.getOperation()) && mathRequest.getOperand2() == (double) 0){
            throw new InvalidOperationException("Cannot divide by 0");
        }
        switch (mathRequest.getOperation()){
            case "*":
                return Math.floor(mathRequest.getOperand1() * mathRequest.getOperand2());
            case "/":
                return Math.floor(mathRequest.getOperand1() / mathRequest.getOperand2());
            case "+":
                return Math.floor(mathRequest.getOperand1() + mathRequest.getOperand2());
            case "-":
                return mathRequest.getOperand1() - mathRequest.getOperand2();
            case "**":
                return Math.pow(mathRequest.getOperand1(), mathRequest.getOperand2());
            case "log":
                return mathRequest.getOperand1() * Math.log10(mathRequest.getOperand2());
            case "ln":
                return mathRequest.getOperand1() * Math.log(mathRequest.getOperand2());
            default:
                throw new RuntimeException("Unknown operation");


        }
    }
}
