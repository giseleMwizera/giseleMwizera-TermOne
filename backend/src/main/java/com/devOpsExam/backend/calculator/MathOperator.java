package com.devOpsExam.backend.calculator;

public interface MathOperator {
double doMath(DoMathRequest mathRequest) throws InvalidOperationException;

}
