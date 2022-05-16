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

        @Override
        public String toString() {
            String gender = ((ssn.substring(ssn.lastIndexOf("-")+1).equals("1") || ssn.substring(ssn.lastIndexOf("-")+1).equals("3") ) ? "남자" : "여자");
            int year = ((Integer.parseInt(ssn.substring(7))<=2) ? Integer.parseInt(ssn.substring(0, 2))+1900 : Integer.parseInt(ssn.substring(0, 2))+2000);
            int age = 2022-year+1;
            return String.format("%s님의 나이는 %d세, 성별은 %s입니다.", name, age, gender);
        }
    }
    interface PersonService{ Person search(List<Person> arr);}

    static class PersonServiceImpl implements PersonService{
        @Override
        public Person search(List<Person> arr) {
            return arr
                    .stream()
                    .filter(e -> e.getName().equals("하진희"))
                    .collect(Collectors.toList()).get(0);
        }
    }
    @Test
    void personStreamTest(){
        List<Person> arr = Arrays.asList(
                Person.builder().name("홍길동").ssn("900120-1").build(),
                Person.builder().name("김유신").ssn("970620-1").build(),
                Person.builder().name("유관순").ssn("040920-4").build(),
                Person.builder().name("하진희").ssn("920530-2").build()
        );
        System.out.println(new PersonServiceImpl()
                .search(arr));


}}
