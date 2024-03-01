package org.example;

public class CorrectFixdPasswordGenerator implements PasswordGenerator{

    @Override
    public String generatePassword(){
        return "abcdefgh";//8글자
    }
}
