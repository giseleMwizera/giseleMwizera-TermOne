package com.devOpsExam.backend.calculator.unitTest;

import com.devOpsExam.backend.calculator.DoMathRequest;
import com.devOpsExam.backend.calculator.InvalidOperationException;
import com.devOpsExam.backend.calculator.MathOperatorImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MathOperatorImplTest {
       @Autowired
      private MathOperatorImpl underTest = new MathOperatorImpl();


    @Test
    void throwErrorIfDividingByZero(){
        DoMathRequest mathRequest = new DoMathRequest(1,0, "/");
        assertThatThrownBy(() -> underTest.doMath(mathRequest)).isInstanceOf(InvalidOperationException.class);
    }

    @Test
    void itShouldPerformAddition() throws InvalidOperationException {
        //given
        DoMathRequest mathRequest = new DoMathRequest(1,3, "+");
        //when
        double result = underTest.doMath(mathRequest);
        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void itShouldPerformSubtraction() throws InvalidOperationException {
        //given
        DoMathRequest mathRequest = new DoMathRequest(4,2, "-");
        //when
        double result = underTest.doMath(mathRequest);
        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void itShouldPerformMultiplication() throws InvalidOperationException {
        //given
        DoMathRequest mathRequest = new DoMathRequest(4,2, "*");
        //when
        double result = underTest.doMath(mathRequest);
        //then
        assertThat(result).isEqualTo(8);
    }
    @Test
    void itShouldPerformDivision() throws InvalidOperationException {
        //given
        DoMathRequest mathRequest = new DoMathRequest(4,2, "/");
        //when
        double result = underTest.doMath(mathRequest);
        //then
        assertThat(result).isEqualTo(2);
    }
    @Test
    void itShouldPowerOperand1ToOperand2() throws InvalidOperationException {
        //given
        DoMathRequest mathRequest = new DoMathRequest(4,2, "**");
        //when
        double result = underTest.doMath(mathRequest);
        //then
        assertThat(result).isEqualTo(16);
    }

    @Test
    void itShouldCalucateTheLogarithm() throws InvalidOperationException {
        //given
        DoMathRequest mathRequest = new DoMathRequest(4,10, "log");
        //when
        double result = underTest.doMath(mathRequest);
        //then
        assertThat(result).isEqualTo(4);
    }
    @Test
    void itShouldReturnErrorOnInvalidOperation() throws InvalidOperationException {
        //given
        DoMathRequest mathRequest = new DoMathRequest(4,10, "");
        //when
        //then
        assertThatThrownBy(()-> underTest.doMath(mathRequest)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Unknown operation");
    }

}