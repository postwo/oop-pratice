package org.example;

public class User {
    private String password;



    //패스워드를 초기화 해주는 메소드
    public void initPassword(PasswordGenerator PasswordGenerator){
      //RandomPasswordGenerator generator  = new  RandomPasswordGenerator(); // 랜덤 패스워드 제너레이터 생성
      String password = PasswordGenerator.generatePassword();
      /*비밀번호는 최소 8자 이상 12자 이하여야 한다
      * */

      if(password.length() >= 8 && password.length() <=12){ //2글자를 받으면 항상 초기화가 되지 않는다
          this.password = password;
      }



    }

    public String getPassword() {
        return password;
    }
}
