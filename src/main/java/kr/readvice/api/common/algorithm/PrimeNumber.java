package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;


public class PrimeNumber {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    private static class Solution{
        private int start, end;
        private String prime;
        private int count;

        @Override
        public String toString() {
            return String.format("소수는 %d개, [%s]입니다.", count, prime);
        }
    }

    @FunctionalInterface
    private interface SolutionService{
        Solution solution(int a, int b);
    }

    @Test
    void solutionTest(){
        SolutionService f = (x, y) -> {
            String prime = "";
            int count = 0;
            for (int i = x; i<y; i++) {
                boolean flag = true;
                if (i == 1) {
                    flag = false;
                    continue;
                }
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    count++;
                    prime += i + "\t";
                }
            }
                return Solution.builder().prime(prime).count(count).build();
        };
        System.out.println(f.solution(1, 100));
    }
};
