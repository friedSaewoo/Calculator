package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// T = 숫자 (int,double.long .....)
public class ArithmeticCalculator<T extends Number> {
    private final List<T> resultList = new ArrayList<>();

    // 연산 메서드
    // Enum의 추상메서드를 오버라이딩한 메서드들로 연산
    public T calculate(T firstNum, T secondNum, OperatorType operator) {
        T result = operator.apply(firstNum, secondNum);
        resultList.add(result);
        return result;
    }

    // 계산 결과 삭제 메서드
    public void removeResult() {
        // 리스트가 비었는지 확인 후 삭제
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        } else {
            throw new IndexOutOfBoundsException("Result list is empty.");
        }
    }

    // 리스트 getter 선언
    public List<T> getResultList() {
        return resultList;
    }

    // 특정 값보다 큰 결과 조회 (Lambda & Stream 활용)
    public List<T> getResultsGreaterThan(T value) {
        return resultList.stream()
                .filter(result -> result.doubleValue() > value.doubleValue())
                .collect(Collectors.toList());
    }
}