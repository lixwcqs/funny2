package com.cqs.rpc.hessian;

import org.springframework.stereotype.Component;

@Component("calculationBean")
public class CalculationImpl implements Calculation {
    public int cube(int number) {
        return number * number * number;
    }
}  