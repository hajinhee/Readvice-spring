package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CheckSameArray {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    private static class Solution{
        private List<Integer> list;

    }
    @FunctionalInterface
    interface SolutionService{
        Boolean solution(List<Solution> l);
    }

    @Test
    void solutionTest(){
        List<Solution> list = Arrays.asList(
                Solution.builder().list(Arrays.asList(1, 3, 2)).build(),
                Solution.builder().list(Arrays.asList(2, 3, 1)).build()
        );
        SolutionService sol = (x) -> x.get(0).getList().containsAll(x.get(1).getList());
        System.out.println(sol.solution(list));
    }
}
