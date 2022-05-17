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
    private static class Solution{
        String c;

    }

    interface SolutionService{}

    @Test
    void solutionTest(){}

}
