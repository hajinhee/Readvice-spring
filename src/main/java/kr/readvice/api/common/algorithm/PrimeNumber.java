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

        @Override
        public String toString() {
            return String.format("소수는 [%s]입니다.", prime);
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
            for (int i = x; i<y; i++) {
                boolean b = true;
                if (i == 1) {
                    b = false;
                    continue;
                }
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    prime += i + "\t";
                }
            }
                return Solution.builder()
                        .prime(prime).build();
        };
//        Solution s = Solution.builder().start(1).end(100).build();
        System.out.println(f.solution(1, 110));
    }
};
