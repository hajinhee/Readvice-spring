package kr.readvice.api.domains;

import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Data
@Component //컴포넌트는 프로퍼티와 메소드의 집합이다.
@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String userid; //userid 랑 이름으로 column 생성
    @Column(nullable = false) private String password;
    @Column(nullable = false) private String email;
    @Column(nullable = false) private String name;
    private String phone;
    private String birth;
    private String address;

}
