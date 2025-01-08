package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> resultList = new ArrayList();
    private int result = 0;

    public int calculate (int firstNum, int secondNum,char symbol){
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
                 result = firstNum / secondNum;
                break;
        }
        resultList.add(result);
        return result;
    }

    public void removeResult() {
        if(resultList.isEmpty()){
           throw new IndexOutOfBoundsException("List is Empty");
        }
            resultList.remove(0);
    }

    public List<Integer> getResultList() {
        return resultList;
    }
    public void setResultList(List<Integer> resultList) {
        this.resultList = resultList;
    }
    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
}
