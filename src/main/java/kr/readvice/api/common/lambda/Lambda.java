package kr.readvice.api.common.lambda;

import static kr.readvice.api.common.dataStructure.AppleList.Apple;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;


public class Lambda {
    public static void main(String[] args) {
//        System.out.println(integer("900"));
        System.out.println(new Apple.Builder().origin("영동").color("Red").price(3000).build());
        System.out.println(
                string(Arrays.asList(
                        new Apple.Builder().origin("영동").color("Red").price(1000).build(),
                        new Apple.Builder().origin("영동").color("Blue").price(1500).build(),
                        new Apple.Builder().origin("풍기").color("Red").price(2000).build()))
        );
        System.out.println(
                array(8).length
        );
    }
    // param:String -> return:Integer
    public static int integer(String s){
        //Integer i = Integer.parseInt(Object);
        Function<String, Integer> f = Integer::parseInt;
        // param과 return(int)이 있으니 순수함수, apply 사용한다.
        return f.apply(s);
    }
    // param:Object -> return:String
    public static String string(Object o){
        //String s = String.valueOf(Object);
        Function<Object, String> f = String::valueOf;
        // param과 return(int)이 있으니 순수함수, apply 사용한다.
        return f.apply(o);
    }
    // param:String -> return:Boolean
    // returnType: Boolean 이므로 Predicate, test 사용
    public static boolean equals(String s1, String s2){
        // Predicate로 return타입이 boolean으로 정해져 있으니 리턴값은 굳이 적지 않는다.
        BiPredicate<String, String> p = String::equals;
        return p.test(s1, s2);
    }

    public static int[] array(Integer i){
        Function<Integer, int[]> f = int[]::new;
        return f.apply(i);
    }
}
