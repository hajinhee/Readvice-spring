package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CheckSameArray {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    private static class Solution{
        private int[] a;
        private int[] b;
        String c;

        @Override
        public String toString() {
            return String.format("%s", c);
        }
    }

    interface SolutionService{
        String solution(int[] a, int[] b);
    }

    @Test
    void solutionTest(){}
}
