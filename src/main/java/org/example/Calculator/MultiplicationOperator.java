package org.example.Calculator;

public class MultiplicationOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "*".equals(operator);
    }

    @Override
    public int calculate(PasitiveNumber operand1, PasitiveNumber operand2) {
        return operand1.toInt() * operand2.toInt();
    }
}
