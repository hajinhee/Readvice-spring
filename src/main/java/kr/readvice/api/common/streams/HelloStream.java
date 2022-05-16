package kr.readvice.api.common.streams;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//한국어 안녕, 영어 Hello
public class HelloStream {
    @Data
    public static class Hello{
        private String greeting, inLanguage;
        /**
        public Hello(Builder builder) {
            this.greeting = builder.greeting;
            this.inLanguage = builder.inLanguage;
        }
        static public class Builder{
            private String greeting, inLanguage;
            public Builder greeting(String greeting){this.greeting=greeting; return this;}
            public Builder inLanguage(String inLanguage){this.inLanguage=inLanguage; return this;}
            public Hello build(){ return new Hello(this);}
        }

        @Override
        public String toString() {
            return String.format("인사: %s, %s", inLanguage, greeting);
        }*/
    }

    interface HelloService{
        // void greet();
        Set<String> greet(String[] arr);
    }

    @Test
    void HelloTest(){
        String[] arr = {"한국어로 안녕", "영어로 Hello"}; // 출력되는 곳에 위치 -> 파라미터로 들어가야 함

        Set<String> s = new HelloService() {
            @Override
            public Set<String> greet(String[] arr) {
                return Arrays.asList(arr)
                        .stream()
                        .filter(e -> e.startsWith("영어"))
                        .collect(Collectors.toSet());
            }
        }.greet(arr);
//        s.forEach(System.out::println);
    }
}
