package com.example.calculator.lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 계산할 값을 저장할 변수 생성 및 초기화
            int firstNum = 0;
            int secondNum = 0;
            int result = 0;
            char symbol='0';
            String exit ="";
            // while문 안에서 양의 정수를 입력받고, 그외의 수가 입력되면 다시 입력을 받는다.
            System.out.println("\n==========계산기==========");
            while (true) {
                try {
                    System.out.print("첫 번째 숫자를 입력하세요 : ");
                    firstNum = Integer.parseInt(sc.nextLine());
                    System.out.print("두 번째 숫자를 입력하세요 : ");
                    secondNum = Integer.parseInt(sc.nextLine());

                    // 음의 정수를 입력받았을때 재입력받는다.
                    if (firstNum < 0 || secondNum < 0) {
                        System.out.println("\n양의 정수를 입력해주세요!");
                        System.out.println("==========계산기==========");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) { // 실수를 입력받았을때 예외처리
                    System.out.println("\n양의 정수를 입력해주세요!");
                    System.out.println("==========계산기==========");
                }
            }
            
            while(true) {
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /) :");
                symbol = sc.nextLine().charAt(0);
                // 입력받은 symbol에 따라 두 수 계산
                switch (symbol){
                    case '+':
                        result = firstNum + secondNum;
                        break;
                    case '-':
                        result = firstNum - secondNum;
                        break;
                    case '*':
                        result = firstNum * secondNum;
                        break;
                    case '/':
                        // 분모가 0일때 예외처리
                        try {
                            result = firstNum / secondNum;
                        }catch (ArithmeticException ae){
                            System.out.println("\n분모가 0일수 없습니다, 다른 기호를 입력해주세요\n");
                            continue;
                        }
                        break;
                    default:
                        System.out.println("잘못된 입력입니다!!\n");
                        continue;
                }
                System.out.println("계산 결과 : "+ result);
                break;
            }
            System.out.print("계속하시려면 아무키나 입력하세요 (exit 입력 시 종료) : ");
            exit = sc.nextLine();
            if(exit.equals("exit")){
                break;
            }
        }

    }
}