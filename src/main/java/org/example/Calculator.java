package org.example;

public class Calculator {
    public static int calculate(int operand1, String operateor, int operand2) {
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

        //calculateor가 직접 자신이 계산하는게 아니라
        return ArithmeticOperator.calculate(operand1,operateor,operand2); //operand1,operateor,operand2 3개의 값을 ArithmeticOperator.calculate에 전달한다
    }
}
