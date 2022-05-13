package kr.readvice.api.common.ennum;

import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("+: "+Operation.PLUS.apply(7, 5));
        System.out.println("-: "+Operation.MINUS.apply(7, 5));
        System.out.println("*: "+Operation.MULTI.apply(7, 5));
        System.out.println("/: "+Operation.DIVIDE.apply(7, 5));

    }
    //switch case 없이 계산기 생성
    @RequiredArgsConstructor
    enum Operation {
        PLUS("+", (x, y)->(x+y)),
        MINUS("-", (x, y)->(x-y)),
        MULTI("*", (x, y)->(x*y)),
        DIVIDE("/", (x, y)->(x/y)),
        ;
        private final String opcode;
        private final BiFunction<Integer, Integer, Integer> f;
        @Override public String toString() {return opcode;}
        public int apply(int a, int b){return f.apply(a,b);}
    }
}
