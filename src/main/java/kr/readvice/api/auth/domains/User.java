package kr.readvice.api.auth.domains;

import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Data
@Component // = DTO라는 의미. 컴포넌트는 프로퍼티와 메소드의 집합이다.
@Entity // JPA에서 사용할 엔티티, ResponseEntity
@Table(name="users") //엔티티와 매핑할 테이블 이름 지정
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String userid; //userid 란 이름으로 column 생성
    @Column(nullable = false) private String password;
    @Column(nullable = false) private String email;
    @Column(nullable = false) private String name;
    private String phone;
    private String birth;
    private String address;

}
