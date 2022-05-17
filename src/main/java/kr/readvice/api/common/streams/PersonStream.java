package kr.readvice.api.common.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonStream {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    static class Person{
        private String name, ssn;
        private Boolean getGenderChecker(String s){
            return ssn.substring(7).equals(s);
        }
        @Override
        public String toString() {
            String gender = (getGenderChecker("1") || getGenderChecker("3" ) ? "남자" : "여자");
            int year = ((Integer.parseInt(ssn.substring(7))<=2) ? Integer.parseInt(ssn.substring(0, 2))+1900 : Integer.parseInt(ssn.substring(0, 2))+2000);
            int age = 2022-year;
            return String.format("%s님의 나이는 %d세, 성별은 %s입니다.", name, age, gender);
        }
    }
    // 기능
    //@FunctionalInterface -> 하나의 메소드만 존재해야 한다.
    @FunctionalInterface interface PersonService{
        Person search(List<Person> person);
    }

    @Test
    void personStreamTest(){
        // 주어진 값
        List<Person> arr = Arrays.asList(
                Person.builder().name("홍길동").ssn("900120-1").build(),
                Person.builder().name("김유신").ssn("970620-1").build(),
                Person.builder().name("유관순").ssn("040920-4").build(),
                Person.builder().name("하진희").ssn("920530-2").build()
        );
        PersonService ps = (person) ->  person
                .stream()
                .filter(e -> e.getName().equals("하진희"))
                .collect(Collectors.toList()).get(0);
        System.out.println(ps.search(arr));


}}
