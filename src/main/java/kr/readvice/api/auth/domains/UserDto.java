package kr.readvice.api.auth.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * packageName: kr.readvice.api.auth.domains
 * fileName        : UserDto
 * author           : 하진희
 * date               : 2022-05-24
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-24         하진희        최초 생성
 */
@Component // = DTO라는 의미. 컴포넌트는 프로퍼티와 메소드의 집합이다.
@Data
public class UserDto {
    @ApiModelProperty private long uerId;
}
