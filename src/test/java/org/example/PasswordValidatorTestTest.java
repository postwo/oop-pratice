package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

// 요구사항
//• 비밀번호는 최소 8자 이상 12자 이하여야 한다.
//• 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생
//        시킨다.
//• 경계조건에 대해 테스트 코드를 작성해야 한다


class PasswordValidatorTestTest {

    @DisplayName("비밀버호가 최소 8자 이상 ,12자 이하면 예외가 발생하지 않는다")//DisplayName 해당 코드에 의도를 가르쳐주기 위해 사용
    @Test
    void validatePassswordTest(){
        //assertThatCode 안의PasswordValidator.validate("serverwizard")이게 호출이 되었을때 doesNotThrowAnyException() 일걸 통해서 예외가 발생하지 않게 한다
        assertThatCode(() -> PasswordValidator.validate("serverwizard")) //PasswordValidator 클래스에게 validate를 맡긴다 비밀번호가  serverwizard에대해서
                .doesNotThrowAnyException();

    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
    void validatePasswordTest2(String value) {
        // given
        PasswordValidator passwordValidator = new PasswordValidator();

        // when, then
        assertThatCode(() -> passwordValidator.validate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }





}