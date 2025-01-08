package com.example.calculator.lv3;

//
@SuppressWarnings("unchecked")
//
public enum OperatorType {
    // 각 연산자 별로 연산 처리, 두 수 모두 정수일경우 Integer로 반환, 두 수중 하나라도 실수일 경우 Double로 반환
    ADD("+") {
        @Override
        public <T extends Number> T apply(T firstNum, T secondNum) {
            if (firstNum instanceof Integer && secondNum instanceof Integer) {
                return (T) Integer.valueOf(firstNum.intValue() + secondNum.intValue()); // 결과값을 T로 강제형변환
            }
            return (T) Double.valueOf(firstNum.doubleValue() + secondNum.doubleValue());
        }
    },
    SUBTRACT("-") {
        @Override
        public <T extends Number> T apply(T firstNum, T secondNum) {
            if (firstNum instanceof Integer && secondNum instanceof Integer) {
                return (T) Integer.valueOf(firstNum.intValue() - secondNum.intValue());
            }
            return (T) Double.valueOf(firstNum.doubleValue() - secondNum.doubleValue());
        }
    },
    MULTIPLY("*") {
        @Override
        public <T extends Number> T apply(T firstNum, T secondNum) {
            if (firstNum instanceof Integer && secondNum instanceof Integer) {
                return (T) Integer.valueOf(firstNum.intValue() * secondNum.intValue());
            }
            return (T) Double.valueOf(firstNum.doubleValue() * secondNum.doubleValue());
        }
    },
    DIVIDE("/") {
        @Override
        public <T extends Number> T apply(T firstNum, T secondNum) {
            if (secondNum.doubleValue() == 0) {     // 두번째 수가 0일 경우 예외처리
                throw new ArithmeticException("0으로 나눌수 없습니다.");
            }
            return (T) Double.valueOf(firstNum.doubleValue() / secondNum.doubleValue());
        }
    };
    // 연산자를 저장하는 변수
    private final String symbol;

    // 생성자
    OperatorType(String symbol) {
        this.symbol = symbol;
    }
    // 연산자 getter
    public String getSymbol() {
        return symbol;
    }
    // 연산 추상메서드 선언
    public abstract <T extends Number> T apply(T a, T b);
}