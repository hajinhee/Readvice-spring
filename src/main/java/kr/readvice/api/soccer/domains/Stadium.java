package kr.readvice.api.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Component
@Entity
@Table(name = "stadium")
public class Stadium{
    @Id private Long id;
    @Column(nullable = false) private String stadiumId;
    @Column private String stadiumName;
    @Column(nullable = false) private String hometeamId;
    @Column private int seatCount;
    @Column private String address;
    @Column private String ddd;
    @Column private String tel;
}
