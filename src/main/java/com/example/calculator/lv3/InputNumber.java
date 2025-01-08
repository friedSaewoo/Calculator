package com.example.calculator.lv3;

// 입력받은 타입에 따라 double, int로 변환하는 메서드
public class InputNumber {
    public static Number parseInput(String input){
        try {
            if (input.contains(".")) {
                return Double.parseDouble(input);
            } else {
                return Integer.parseInt(input);
            }
        }catch (NumberFormatException e){
                throw new NumberFormatException("잘못된 입력"+input);
        }
    }
}
