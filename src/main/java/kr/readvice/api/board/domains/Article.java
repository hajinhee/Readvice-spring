package kr.readvice.api.board.domains;

import kr.readvice.api.user.domains.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @Column(name = "article_id") private long articleId;
    private String title;
    private String content;
    private String writtenDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //외래 키 매핑 시 사용
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id") //외래 키 매핑 시 사용
    private Board board;


}
