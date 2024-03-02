package org.example.Calculator;

public class SubtractionOperator implements NewArithmeticOperator {


    @Override
    public boolean supports(String operator) {
        return "-".equals(operator); // -기호하고 operator가 같으면
    }

    @Override
    public int calculate(PasitiveNumber operand1, PasitiveNumber operand2) {
        return operand1.toInt() - operand2.toInt(); //operand1 - operand2를 빼서 반환
    }
}
