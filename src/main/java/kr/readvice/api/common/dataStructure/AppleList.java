package kr.readvice.api.common.dataStructure;

import kr.readvice.api.common.lambda.Lambda;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Apple color, price, origin
// HashMap id = key, List id = index
public class AppleList {
    //controller = router
    public static void main(String[] args) {
        AppleService service = new AppleServiceImpl();
        while (true){
            Scanner s = new Scanner(System.in);
            System.out.println("0.exit 1.save 2.update 3.delete 4.findById 5.findByOrigin 6.findByColor 7.findAll 8.count 9.clear");
            switch (s.next()){
                case "0": return;
                case "1":
                    System.out.println("1. save");
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
                    break;
                case "2":
                    System.out.println("2. update");

                    break;
                case "3":
                    System.out.println("3. delete");
                    break;
                case "4":
                    System.out.println("4. findById");
                    System.out.println((service.findById(0) != null) ? service.findById(0) : "찾는 사과가 없습니다.");
                    break;
                case "5":
                    System.out.println("5. findByOrigin");
                    System.out.println(service.findByOrigin("영동"));
                    break;
                case "6":
                    System.out.println("6. findByColor");
                    System.out.println(service.findByColor("Red"));
                    break;
                case "7":
                    System.out.println("7. findAll");
                    System.out.println(service.findAll());
                    break;
                case "8":
                    System.out.println("8. count");
                    System.out.println("총 사과 수: "+service.count()+"개");
                    break;
                case "9":
                    System.out.println("9. clear");
                    service.clear();
                case "10":
                    System.out.println("사과 가격은 "+ Lambda.integer(""));
                    break;
                default: break;
            }
        }
    }
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
            return null;
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

}
