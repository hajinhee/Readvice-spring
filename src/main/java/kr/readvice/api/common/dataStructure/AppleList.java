package kr.readvice.api.common.dataStructure;

import static kr.readvice.api.common.lambda.Lambda.*;

import kr.readvice.api.common.lambda.Lambda;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Apple color, price, origin
// HashMap id = key, List id = index
public class AppleList {

    //domain DTO
    @Data
    @NoArgsConstructor
    public static class Apple{
        private String color, origin;
        private int price;

        public Apple(Builder builder) {
            this.origin = builder.origin;
            this.color = builder.color;
            this.price = builder.price;
        }

        @NoArgsConstructor static public class Builder{
            private String color, origin;
            private int price;
            public Builder origin(String origin){this.origin=origin; return this;}
            public Builder color(String color){this.color=color; return this;}
            public Builder price(int price){this.price=price; return this;}
            public Apple build(){ return new Apple(this);}
        }

        @Override
        public String toString() {
            return String.format("[사과 스펙] origin: %s, color: %s, price: %d",
                    origin, color, price);
        }
    }
    //service interface
    interface AppleService{
        void save(Apple apple);
        void update(int i, Apple apple);
        void delete(Apple apple);
        void clear();
        Apple findById(int i);
        List<Apple> findAll();
        List<Apple> findByOrigin(String origin);
        List<Apple> findByColor(String color);
        int count();

    }
    //serviceImpl = middleware
    static class AppleServiceImpl implements AppleService{
        private final List<Apple> list;

        public AppleServiceImpl() {
            list = new ArrayList<>();
        }

        @Override
        public void save(Apple apple) {
            list.add(apple);
        }

        @Override
        public void update(int i, Apple apple) {
            list.set(i, apple);
        }

        @Override
        public void delete(Apple apple) {
            list.remove(apple);
        }

        @Override
        public void clear() {
            list.clear();
        }

        @Override
        public List<Apple> findByColor(String color) {
            return list.stream()
                    .filter(apple -> apple.getColor().equals(color))
                    .collect(Collectors.toList());
        }

        @Override
        public Apple findById(int i) {
            return list.get(i);
        }

        @Override
        public List<Apple> findAll() {
            return list;
        }

        @Override
        public List<Apple> findByOrigin(String origin) {
            return list.stream()
                    .filter(apple -> apple.getOrigin().equals(origin))
                    .collect(Collectors.toList());
        }

        @Override
        public int count() {
            return list.size();
        }
    }
    @Test
    void appleTest(){
        AppleService service = new AppleServiceImpl();
        System.out.println("### save ###");
        Apple yd = new Apple.Builder()
                .origin("영동")
                .color("Red")
                .price(1000)
                .build();
        service.save(yd);
        Apple yd2 = new Apple.Builder()
                .origin("영동")
                .color("Blue")
                .price(1500)
                .build();
        service.save(yd2);
        Apple pg = new Apple.Builder()
                .origin("풍기")
                .color("Red")
                .price(20000)
                .build();
        service.save(pg);
        System.out.println("### update ###");
        service.update(0, new Apple.Builder()
                .origin("캘리포니아")
                .color("YELLOW")
                .price(20000)
                .build());
        System.out.println("### delete ###");
        service.delete(new Apple.Builder()
                .origin("캘리포니아")
                .color("YELLOW")
                .price(20000)
                .build());
        System.out.println("### findById ###");
        System.out.println("첫번째 사과 정보: "+ service.findById(0));
        System.out.println("### findByOrigin ###");
        System.out.println("원산지가 [영동]인 사과 정보: "+service.findByOrigin("영동"));
        System.out.println("### findByColor ###");
        System.out.println("색이 [Red]인 사과 정보: "+service.findByColor("Red"));
        System.out.println("### findAll ###");
        System.out.println("전체 사과 정보: "+service.findAll());
        System.out.println("### count ###");
        System.out.println("총 사과 수: "+service.count()+"개");
        System.out.println("### clear ###");
        service.clear();
        System.out.println("사과 가격은 "+ integer("1000"));
        System.out.println("내가 만든 배열의 사이즈는 "+ array(7));
            }
        }
