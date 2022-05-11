package kr.readvice.api.common.dataStructure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

// height, weight, ssn(900101-1)
public class BmiList {
    public static void main(String[] args) {

    }
    //domain
    @Data
    static class Bmi{
        protected double height, weight;
        protected String ssn;

        public Bmi(Builder builder) {
            this.ssn = builder.ssn;
            this.height = builder.height;
            this.weight = builder.weight;
        }
        @NoArgsConstructor static class Builder{
            private double height, weight;
            private String ssn;
            public Builder ssn(String ssn){this.ssn=ssn; return this;}
            public Builder height(double height){this.height=height; return this;}
            public Builder weight(double weight){this.weight=weight; return this;}
            Bmi Build(){return new Bmi(this);}
        }
        @Override
        public String toString() {
            return String.format("[bmi] 키: %.2f, 몸무게: %.2f, 생년월일: %s", height, weight, ssn);
        }
    }
    interface BmiService{
        void save(Bmi bmi);
        void update(int i, Bmi bmi);
        void delete(Bmi bmi);
        void clear();
        List<Bmi> findAll();
        List<Bmi> findByNGender(String gender);
        Bmi findById(int i);
        int count();
    }

    static class BmiServiceImpl implements BmiService{
        private final List<Bmi> list;
        public BmiServiceImpl() {
            list = new ArrayList<>();
        }


        @Override
        public void save(Bmi bmi) {
            list.add(bmi);

        }

        @Override
        public void update(int i, Bmi bmi) {
            list.set(i, bmi);

        }

        @Override
        public void delete(Bmi bmi) {
            list.remove(bmi);

        }

        @Override
        public void clear() {
            list.clear();
        }

        @Override
        public List<Bmi> findAll() {
            return null;
        }

        @Override
        public List<Bmi> findByNGender(String gender) {
            return null;
        }

        @Override
        public Bmi findById(int i) {
            return list.get(i);
        }

        @Override
        public int count() {
            return list.size();
        }
    }
}
