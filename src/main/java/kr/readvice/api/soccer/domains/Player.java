package kr.readvice.api.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(name = "palyer")
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String playerId;
    @Column private String playerName;
    @Column(nullable = false) private String teamId;
    @Column private String ePlayerName;
    @Column private String nickName;
    @Column private String joinYyyy;
    @Column private String position;
    @Column private String backNo;
    @Column private String nation;
    @Column private String birthDate;
    @Column private String solar;
    @Column private String height;
    @Column private String weight;
}
