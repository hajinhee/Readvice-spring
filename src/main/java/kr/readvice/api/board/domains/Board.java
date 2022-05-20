package kr.readvice.api.board.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
@Entity
@Table(name = "boards")
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue
    private Long boardId;
    @Column private @NotNull
    String boardName;
    @Column(name = "create_date") @NotNull private String createDate;

    @OneToMany(mappedBy = "board")
    List<Article> articles = new ArrayList<>();

}
