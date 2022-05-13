package kr.readvice.api.common.ennum;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

public class Calculator {
    @RequiredArgsConstructor
    enum Operation{
        PLUS("+", (a,b)->(a+b)),
        MINUS("-", (a,b)->(a-b)),
        MULTI("*", (a,b)->(a*b)),
        DIVIDE("/", (a,b)->(a/b)),
        ;

        private final String opcode;
        private final BiFunction<Integer, Integer, Integer> f;

        @Override
        public String toString() {return opcode;}
        public int apply(int a, int b){return f.apply(a, b);}
    }
    @Test
    void calculatorTest(){
            System.out.println("+: " +Operation.PLUS.apply(1, 5));
            System.out.println("-: " +Operation.MINUS.apply(1, 5));
            System.out.println("*: " +Operation.MULTI.apply(1, 5));
            System.out.println("/: " +Operation.DIVIDE.apply(1, 5));
    }
}
