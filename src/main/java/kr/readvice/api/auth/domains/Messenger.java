package kr.readvice.api.auth.domains;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName: kr.readvice.api.security.domains
 * fileName        : Messenger
 * author           : 하진희
 * date               : 2022-05-23
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-23         하진희        최초 생성
 */
@Getter @Builder
public class Messenger {
    private String message, code;
    private int status;
}
