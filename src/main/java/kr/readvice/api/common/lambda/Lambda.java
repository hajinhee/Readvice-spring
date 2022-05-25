package kr.readvice.api.common.lambda;

import org.apache.tomcat.jni.File;

import static kr.readvice.api.common.dataStructure.AppleList.Apple;

import java.util.Arrays;
import java.util.function.*;


public class Lambda {
    public static void main(String[] args) {
//        System.out.println(integer("900"));
        System.out.println(new Apple.Builder());
                            // 인스턴스는 new생성자를 통해 만든다.
        System.out.println(
                string(Arrays.asList(
                        new Apple.Builder().origin("영동").color("Red").price(1000).build(),
                        new Apple.Builder().origin("영동").color("Blue").price(1500).build(),
                        new Apple.Builder().origin("풍기").color("Red").price(2000).build()))
        );
        System.out.println(
                array(8).length
        );
        System.out.println(random(1, 1000));

    }
    // String -> Integer
    public static int integer(String s){
        //Integer i = Integer.parseInt(Object);
        Function<String, Integer> f = Integer::parseInt;
        // param과 return(int)이 있으니 순수함수, apply 사용한다.
        return f.apply(s);
    }
    public static long longParse(String s){
        Function<String, Long> f = Long :: parseLong;
        return f.apply(s);
    }
    public static float FloatParse(String s){
        Function<String, Float> f = Float::parseFloat;
        return f.apply(s);
    }


    // Object -> String
    public static String string(Object o){
        //String s = String.valueOf(Object);
        Function<Object, String> f = String::valueOf;
        // param과 return(int)이 있으니 순수함수, apply 사용한다.
        return f.apply(o);
    }
    // Integer -> String
    String choi(int i){
        Function<Integer, String> f = String::valueOf;
        return f.apply(i);
    }
    // String -> Boolean
    public static boolean equals(String s1, String s2){
        BiPredicate<String, String> p = String::equals;
        return p.test(s1, s2);
    }
    // Integer -> int[]
    public static int[] array(Integer i){
        Function<Integer, int[]> f = int[]::new;
        return f.apply(i);
    }
    // int min, int max -> int random(min~max)
    public static int random(int min, int max){
        BiFunction<Integer, Integer, Integer> f = (t, u) -> (int)(Math.random()*u)+t;
        return f.apply(min, max);
    }
    // String -> File
//    public static File makeFile(String s){
//        Function<String , File> f = File::new;
//        return f.apply(s);
//    }
}
