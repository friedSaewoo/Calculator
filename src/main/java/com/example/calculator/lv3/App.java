package com.example.calculator.lv3;

import com.example.calculator.lv2.Calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        com.example.calculator.lv2.Calculator cal = new Calculator();
        while (true) {
            // 계산할 값을 저장할 변수 생성 및 초기화
            int firstNum = 0;
            int secondNum = 0;
            char symbol='0';
            String menu ="";

            // while문 안에서 양의 정수를 입력받고, 그외의 수가 입력되면 다시 입력을 받는다.
            System.out.println("\n===============계산기 프로그램===============");
            System.out.print("무엇을 하시겠습니까? (1-계산기 2-결과 확인 3-exit) : ");
            menu = sc.nextLine();
            switch (menu){
                case "1":
                    while(true) {
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

                        if(symbol == '+' || symbol =='-' || symbol == '*' || symbol == '/'){
                            try {
                                cal.calculate(firstNum,secondNum,symbol);
                            }catch (ArithmeticException ae){
                                System.out.println("\n분모가 0일수 없습니다, 다른 기호를 입력해주세요\n");
                                continue;
                            }
                        }else{
                            System.out.println("잘못된 입력입니다!!\n");
                            continue;
                        }
                        System.out.println("계산 결과 : "+ cal.getResult());
                        break;
                    }
                    break;
                case "2":
                    while (true) {
                        System.out.println("계산 결과 리스트: " + cal.getResultList());
                        System.out.print("1-삭제 2-메뉴 : ");
                        String m = sc.nextLine();
                        switch (m) {
                            case "1":
                                try{
                                    cal.removeResult();
                                }catch (IndexOutOfBoundsException e){
                                    System.out.println("리스트가 비었습니다.\n");
                                    continue;
                                }
                                System.out.println("삭제 완료!!\n");
                                continue;
                            case "2":
                                System.out.println();
                                break;
                            default:
                                System.out.println("다시 입력해주세요\n");
                                continue;

                        }
                        break;
                    }
                    break;
                case "3":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
            }

        }

    }
}