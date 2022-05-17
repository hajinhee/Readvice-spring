package kr.readvice.api.common.algorithm;

import kr.readvice.api.common.streams.PersonStream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMax {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    private static class Solution{
        private int[] arr; // 주어지는 값을 필드에 입력
        private int max, min;

        @Override
        public String toString() {
            return String.format("최소값은 %d, 최대값은 %d입니다.", min, max);
        }
    }
    // 기능
    @FunctionalInterface
    private interface SolutionService{
        Solution solution(Solution s);
    }

    @Test
    void SolutionTest(){
        int[] arr = {3, 1, 9, 5, 10};
        SolutionService f = e -> {
            int max = 0;
            for(int i : e.getArr()){
                if(i > max) max = i;
            }
            int min = max;
            for(int i : e.getArr()){
                if(i < min) min = i;
            }
            return Solution.builder().max(max)
                    .min(min).build();
        };
        Solution s = Solution.builder().arr(arr).build();
        System.out.println(f.solution(s));
    }
}
