package org.example;

import org.example.Calculator.PasitiveNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    void cteateTest(int value){ //{0,-1} value는 이 두값을 받아서 사용한다
        //0인경우에 밑의 exception을 동작시킨다
        assertThatCode(()-> new PasitiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0또는 음수를 전달할 수 없습니다");
    }
}
