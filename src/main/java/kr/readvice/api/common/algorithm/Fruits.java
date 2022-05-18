package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;


public class Fruits {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    private static class Solution {
        private int[][] arr;
        private int total, apple, grape, orange;

        @Override
        public String toString() {
            return String.format("total: %d \n " +
                            "apple: %d \n grape: %d \n orange: %d",
                    total, apple, grape, orange);
        }
    }
        @FunctionalInterface
        private interface SolutionService {
            Solution solution(Solution s);
        }

        @Test
        void SolutionTest() {
            int[][] arr = {{10000, 20000, 12000},
                    {8000, 3000, 15000},
                    {20000, 15000, 38000},
                    {13000, 20000, 30000},
                    {30000, 12000, 20000},
                    {35000, 30000, 25000},
                    {50000, 23000, 10000}};

            SolutionService f = e -> {
                int total = 0;
                int apple = 0;
                int grape = 0;
                int orange = 0;

                return Solution.builder().total(total).apple(apple).grape(grape).orange(orange).build();
            };
            Solution s = Solution.builder().arr(arr).build();
            System.out.println(f.solution(s));
    }
}
