package kr.readvice.api.common.lambda;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.function.Supplier;

/**
 * packageName: kr.readvice.api.common.lambda
 * fileName        : LambdaLab
 * author           : 하진희
 * date               : 2022-05-26
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-26         하진희        최초 생성
 */
public class LambdaLab {
    public static String solution(){
        Supplier<String> f = () -> String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        Supplier<String> f = () -> String.valueOf(new Date());
        return f.get();
    }
    @Test
    public void testSolution(){
        System.out.println(solution());
    }
}

