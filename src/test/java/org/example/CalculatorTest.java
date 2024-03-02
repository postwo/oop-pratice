package org.example;


import org.assertj.core.util.Streams;
import org.example.Calculator.Calculator;
import org.example.Calculator.PasitiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
* 요구사항
• 간단한 사칙연산을 할 수 있다.
• 양수로만 계산할 수 있다.
• 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
• MVC패턴(Model-View-Controller) 기반으로 구현한다.*/
public class CalculatorTest {

    //1.p연산자와 하나의 연산자를  (1(p연산자)+2(연산자))--->Calculator에게 전달하면서 작업을 미임하면 된다
    //2.Calculator이에대한 결과값을 전달해준다 =3 < -------
//    @DisplayName("덧셈 연산을 정상적으로 수행한다")
//    @Test
//    void additionTest(){
//        int result = Calculator.calculate(1, "+", 2);
//
//        assertThat(result).isEqualTo(3);
//    }
//
//
//    @DisplayName("뺼셈 연산을 정상적으로 수행한다")
//    @Test
//    void subtractionTest(){
//        int result = Calculator.calculate(1, "-", 2);
//
//        assertThat(result).isEqualTo(-1);
//    }

    @DisplayName("덧셈 연산을 정상적으로 수행한다")
    @ParameterizedTest
    @MethodSource("formulaAndResult")//formulaAndResult이 이름의 메소드를 소스로 가진다는 뜻이다
    void CalculaterTest(int operand1,String operrator,int operand2,int result){ // 밑에 arguments(1, "+", 2, 3) 이값들을 인자값으로 받아서 사용
        int CalculateResult = Calculator.calculate(new PasitiveNumber(operand1), operrator, new PasitiveNumber(operand2));//calculate에게 계산을 해달라고 보낸다

        assertThat(CalculateResult).isEqualTo(result);
    }

    //non-static method 이게 뜨는 이유는 Stream메서드를 static으로 변경해줘야 에러가 안뜬다
    private static Stream<Arguments> formulaAndResult() { //내부에서만 사용할거여서 private 선언
        return Stream.of(
                arguments(1, "+", 2, 3), //여기서 부터 순차적으로 밑에꺼 수행
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }


//    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다")
//    @Test
//    void calculaterExceptionTest(){
//       assertThatCode(()-> Calculator.calculate(new PasitiveNumber(10),"/",new PasitiveNumber(0)))
//               .isInstanceOf(IllegalArgumentException.class)//예외가 IllegalArgumentException인지
//                .hasMessage("0으로는 나눌 수 없습니다");
//    }




}
