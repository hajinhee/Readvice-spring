package kr.readvice.api.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String stadiumId;
    @Column(nullable = false) private String scheDate;
    @Column private String gubun;
    @Column private String hometeamId;
    @Column private String awayteamId;
    @Column private int homeScore;
    @Column private int awayScore;

}
