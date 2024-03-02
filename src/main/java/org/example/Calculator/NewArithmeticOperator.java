package org.example.Calculator;

public interface NewArithmeticOperator {
    boolean supports(String operator);
    int calculate(PasitiveNumber operand1,PasitiveNumber operand2);


}
