package kr.readvice.api.user.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;


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
@ToString
public class UserDTO {
    @ApiModelProperty(position = 1) private long uerId;
    @ApiModelProperty(position = 2) String username;
    @ApiModelProperty(position = 3) String password;
    @ApiModelProperty(position = 4) String name;
    @ApiModelProperty(position = 5) String email;
    @ApiModelProperty(position = 6) private String regDate;
    @ApiModelProperty(position = 7) private String token;
    @ApiModelProperty(position = 8) private List<Role> roles;

}
