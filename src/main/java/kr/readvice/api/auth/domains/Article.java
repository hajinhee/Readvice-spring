package kr.readvice.api.auth.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
@Entity
@Table(name="articles")
public class Article {
    // Builder
    @Id @GeneratedValue
    @Column(name = "article_id") private long article_id;
    @Column @NotNull private String title;
    @Column @NotNull private String content;
    @Column(name = "written_date") @NotNull private String writtenDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //외래 키 매핑 시 사용
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id") //외래 키 매핑 시 사용
    private Board board;


}
