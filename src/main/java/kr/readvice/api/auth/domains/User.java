package kr.readvice.api.auth.domains;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component // = DTO라는 의미. 컴포넌트는 프로퍼티와 메소드의 집합이다.
@Entity // JPA에서 사용할 엔티티, ResponseEntity
@Table(name="users") //엔티티와 매핑할 테이블 이름 지정
public class User {
    // Builder
    @Id @GeneratedValue
    @Column(name = "user_id") private long user_id;
    @Column private @NotNull String username;
    @Column private @NotNull String password;
    @Column private @NotNull String name;
    @Column private @NotNull String email;
    @Column(name = "reg_date") @NotNull private String regDate;

    @OneToMany(mappedBy = "user")
    List<Article> articles = new ArrayList<>();
}
