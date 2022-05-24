package kr.readvice.api.auth.exception;

/**
 * packageName: kr.readvice.api.auth.exception
 * fileName        : LoginRunnerException
 * author           : 하진희
 * date               : 2022-05-24
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-24         하진희        최초 생성
 */
public class LoginRunnerException extends RuntimeException {
    private static final long SerializableUID = 1L;

    public LoginRunnerException() {
        super();
    }

    public LoginRunnerException(String msg) {
        super(msg);
    }
}