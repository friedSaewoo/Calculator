package com.example.calculator.lv3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> cal = new ArithmeticCalculator<>();

        // 계산기 프로그램 전체 반복문
        while (true) {
            System.out.println("\n===============계산기 프로그램===============");
            System.out.print("무엇을 하시겠습니까? (1-계산기 2-결과 확인 3-조건 조회 4-exit) : ");
            String menu = sc.nextLine();
            // 1-계산기 2-결과 확인 3-조건 조회 4-exit
            switch (menu) {
                case "1":
                    Number firstNum = 0;
                    Number secondNum = 0;
                    // 계산할 두 수 입력, 잘못된 값 입력시 반복
                    while (true) {
                        try {
                            System.out.print("첫 번째 숫자를 입력하세요 : ");
                            firstNum = InputNumber.parseInput(sc.nextLine());
                            System.out.print("두 번째 숫자를 입력하세요 : ");
                            secondNum = InputNumber.parseInput(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("올바른 숫자를 입력해주세요!\n");
                        }
                    }
                    
                    // 올바른 연산자를 입력받을때 까지 반복
                    OperatorType operator = null;
                    while (operator == null) {
                        System.out.print("사칙연산 기호를 입력하세요(+, -, *, /) : ");
                        String symbol = sc.nextLine();
                        // Enum의 연산자를 순회하며 비교
                        for (OperatorType op : OperatorType.values()) {
                            if (op.getSymbol().equals(symbol)) {
                                operator = op;
                                break;
                            }
                        }
                        // 같은 연산자가 없을시 재입력
                        if (operator == null) {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        }
                    }
                    // Calculator 클래스의 메서드로 연산 후 출력
                    try {
                        Number result = cal.calculate(firstNum, secondNum, operator);
                        System.out.println("계산 결과 : " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("오류 발생: "+ e.getMessage());
                    }
                    break;
                // 연산 결과 출력 및 삭제
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
                    try {
                        System.out.print("기준값을 입력하세요: ");
                        Number input = InputNumber.parseInput(sc.nextLine());
                        System.out.println(input+"보다 큰 결과값: " + cal.getResultsGreaterThan(input));
                    } catch (NumberFormatException e) {
                        System.out.println("올바른 숫자를 입력해주세요!");
                    }
                    break;
                // 프로그램 종료
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}