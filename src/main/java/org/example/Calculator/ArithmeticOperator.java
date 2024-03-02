package org.example.Calculator;

import java.util.Arrays;

public enum ArithmeticOperator {


    ADDITION("+"){ //추상메소드는 enum각각에서 override를 해주는거다
        //추상메서드를 각각 override를 해준거다
        @Override
        public int Arithmeticcalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },SUBTRACTION("-"){
        @Override
        public int Arithmeticcalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },MULTIPLICATION("*"){
        @Override
        public int Arithmeticcalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },DIVISION("/"){
        @Override
        public int Arithmeticcalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;// "+" 이거를 operator라고 명명할거다


    //생성자
    ArithmeticOperator(String operator) {
        this.operator = operator;
    }


    // 추상메서드
    public abstract  int Arithmeticcalculate(final int operand1, final int operand2); //shift+f6으로 메서드이름을 변경이 가능하다


    //여기서 작업을 처리해서 Calculator에게 다시 전달해준다
    public static int calculate(int operand1, String operateor, int operand2) {
        ArithmeticOperator selectedArithmeticOperator = Arrays.stream(ArithmeticOperator.values())// values는  모든 enum값을 가지고 온다
                .filter(v ->v.operator.equals(operateor))// eunm값에 operater(+,/,* 등)같은지
                .findFirst()// operater 값이 같다면 같은것을 가지고 온다
                .orElseThrow(()-> new IllegalArgumentException("올바른 사칙연산이 아닙니다")); // 아무것도 일치하는 연산자(oprater0가 없다면 IllegalArgumentException()에 올바른 사칙연산이 아닙니다 를 보여줄거다

        //일치 하는 operater를 가지고와서  Arithmeticcalculate메소드를 통해 enum메소드를 실행해준다
       return selectedArithmeticOperator.Arithmeticcalculate(operand1,operand2);  //selectedArithmeticOperator지역변수를 가지고 Arithmeticcalculate이 메소드를 호출할 수 있다
    }

    
}