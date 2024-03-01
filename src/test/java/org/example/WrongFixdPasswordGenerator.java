package org.example;

public class WrongFixdPasswordGenerator implements PasswordGenerator{

    @Override
    public String generatePassword(){
        return "ab";//2글자
    }
}
