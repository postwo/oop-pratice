package org.example.Calculator;

public class PasitiveNumber {
    private final int value;

    //양수를 처리해주기위해
    public PasitiveNumber(int value) { // int value가 음수면 밑에 처럼 예외처리한다
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(isNegertiveNumer(value)){ // 음수라면
            throw  new IllegalArgumentException("0또는 음수를 전달할 수 없습니다");
        }
    }

    private boolean isNegertiveNumer(int value) {
        return value <=0;
    }

  
    public int toInt(){ // 계산할때는 int값을 써야하기 떄문에 이걸 만들어서 int값으로 변환 시켜준다
        return value;
        
    }
}
