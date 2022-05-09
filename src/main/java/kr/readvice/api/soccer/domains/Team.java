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
@Table(name = "team")
public class Team {
    @Id private Long id;
    @Column(nullable = false) private String teamId;
    @Column private String regionName;
    @Column private String teamName;
    @Column private String eTeamName;
    @Column private String origYyyy;
    @Column(nullable = false) private String stadiumId;
    @Column private String zipCode1;
    @Column private String zipCode2;
    @Column private String address;
    @Column private String ddd;
    @Column private String tel;
    @Column private String fax;
    @Column private String homepage;
    @Column private String teamOwner;
}

