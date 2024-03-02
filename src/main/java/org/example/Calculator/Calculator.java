package org.example.Calculator;

import java.util.List;

public class Calculator {

    /*new AdditionOperator(),new SubtractionOperator(),
            new MultiplicationOperator(),new DivisionOperator() 여기에 대한 각각의 구현체들을 상위 인터페이스인
            NewArithmeticOperator(이거는 List<NewArithmeticOperator>에 있는 NewArithmeticOperator이걸 뜻한다 )통해서 받는다*/
    private static  final List<NewArithmeticOperator> arithmeticOperator = List.of(new AdditionOperator(),new SubtractionOperator(),
            new MultiplicationOperator(),new DivisionOperator()); // 인터페이스 타입을 가지는 리스트

    public static int calculate(PasitiveNumber operand1, String operateor, PasitiveNumber operand2) {
//        if ("+".equals(operateor)) { // +일때는 밑값을 반환
//            return operand1 + operand2;
//        }else if("-".equals(operateor)){
//            return operand1 - operand2;
//        }else if("*".equals((operateor))){
//            return operand1 * operand2;
//        }else if("/".equals(operateor)){
//            return operand1 / operand2;
//        }
//        return operand1 + operand2;



        //calculateor가 직접 자신이 계산하는게 아니라 ArithmeticOperator enum에게 calculate메소드 다시한번 작업 해달라고 한다
        //이거는 enum방식이다
        //return ArithmeticOperator.calculate(operand1,operateor,operand2); //operand1,operateor,operand2 3개의 값을 ArithmeticOperator.calculate에 전달한다



        return arithmeticOperator.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operateor))//이 operator에 해당하는 실제 구현체를 필터링해서
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1,operand2)) // 인자로 받은operand1,operand2전달해서  calculate에 작업을 위임한다
                .findFirst() //첫번째값을 받는다
                //.supports(operateor) 올바른 연산가 없으면 밑에 문구를 띄워준다
                .orElseThrow(()-> new IllegalArgumentException("올바른 사칙연산이 아닙니다")); //만약에 찾치 못하면 IllegalArgumentException("올바른 사칙연산이 아닙니다") 이거를 보여준다
    }
}
