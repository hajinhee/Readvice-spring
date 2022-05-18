package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Gugudan {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    private static class Solution{
        private int[][] arr;

        @Override
        public String toString() {
            return String.format("구구단: ", arr);
        }
    }
    @FunctionalInterface
    interface SolutionService{
        void solution();
    }

    @Test
    void solutionTest(){
        SolutionService f = () -> {
            for (int i = 2; i < 10; i+=4) {
                for (int j = 1; j < 10; j++) {
                    for (int k = i; k < i+4; k++) {
                        System.out.print((k + "*"+j+"="+(k*j)+"\t"));
                    }
                    System.out.println();
                }System.out.println();
            }
        };
        f.solution();
    }
}
