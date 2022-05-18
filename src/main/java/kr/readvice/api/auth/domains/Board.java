package kr.readvice.api.auth.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;
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
    @Column
    @GeneratedValue
    private Long id;
    @Column private @NotNull
    String boardName;
    @Column(name = "create_date") @NotNull private String create_date;

    @OneToMany(mappedBy = "board")
    List<Article> articles = new ArrayList<>();

}
