package kr.readvice.api.user.repositories;
import kr.readvice.api.user.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface UserCustomRepository{
    // 000. 사용자의 비밀번호와 이메일을 수정하시오

    @Modifying
    @Query(value = "")
    void update(User user);

    @Query(value = "")
    String login(User user);
}

// interface 구현체가 없기 때문에 @Repository가 없으면 NPE 에러가 난다.
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);

}
