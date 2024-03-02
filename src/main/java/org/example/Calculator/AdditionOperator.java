package org.example.Calculator;

public class AdditionOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "+".equals(operator); // +가 같냐?
    }

    @Override
    public int calculate(PasitiveNumber operand1, PasitiveNumber operand2) {
        return operand1.toInt() + operand2.toInt(); //기호가 +와 operator가 같다면  operand1 + operand2를 반환
    }
}
