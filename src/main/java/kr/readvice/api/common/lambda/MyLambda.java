package kr.readvice.api.common.lambda;

import java.util.function.Predicate;

public class MyLambda {
    @FunctionalInterface interface MyFunction{ int execute(String arg);}
    @FunctionalInterface interface MySupplier{ int execute();}
    @FunctionalInterface interface MyConsumer{ void execute(String arg);}
    @FunctionalInterface interface MyPredicate{ boolean execute(String arg);}
    @FunctionalInterface interface MyInterface{ String myMethod();}
    @FunctionalInterface interface MyUnaryOp{ int operator(Integer a);}
    @FunctionalInterface interface MathOperation{ int execute(int a, int b);}
}
