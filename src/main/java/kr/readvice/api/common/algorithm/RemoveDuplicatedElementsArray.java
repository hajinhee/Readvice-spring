package kr.readvice.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatedElementsArray {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    private static class Solution{
        private List<Integer> list;

    }
    @FunctionalInterface
    interface SolutionService{
        List<Integer> solution(Solution s);
    }

    @Test
    void solutionTest(){
        Solution s = Solution.builder().list(Arrays.asList(5,10,9,27,2,8,10,4,27,1)).build();
        SolutionService sol = e -> e.getList().stream().distinct().collect(Collectors.toList());
        System.out.println(sol.solution(s));
    }
}
