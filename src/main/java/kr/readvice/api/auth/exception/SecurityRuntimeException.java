package kr.readvice.api.auth.exception;

/**
 * packageName: kr.readvice.api.auth.exception
 * fileName        : SecurityRuntimeException
 * author           : 하진희
 * date               : 2022-05-24
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-24         하진희        최초 생성
 */
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class SecurityRuntimeException extends RuntimeException{
    private static final long SerializableUID = 1L;

    private final String msg;
    private final HttpStatus httpStatus;
}