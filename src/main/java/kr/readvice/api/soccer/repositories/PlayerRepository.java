package kr.readvice.api.soccer.repositories;

import kr.readvice.api.board.domains.Board;
import kr.readvice.api.soccer.domains.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

interface PlayerCustomRepository{
    // 선수들의 키와 몸무게를 변경하시오
//    @Query(value="update player p set p.height = :height, p.weight = :weight where p.playerNo = :playerNo",
//            nativeQuery = true)
//    int update(@Param("height") String height, @Param("weight") String weight);
//
//    // 002. 플레이어의 포지션 종류를 나열하시오.단 중복은 제거하시오
//    @Query(value = "select distinct p.position from Player p")
//    List<String> findPositions();
//
//    // 004. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오.
//    // 단 수원팀 ID는 K02 입니다.
//    @Query(value = "select p.playerName \n"
//            + "from Player p \n"
//            + "where p.teamId like :teamId and p.position like :teamId%")
//    List<String> findTeamGKByTeamId();
//
//    // 005. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오.
//    // 단 수원팀 ID는 K02 입니다.
//    @Query(value = "select p.playerName \n"
//            + "from Player p \n"
//            + "where p.teamId like :teamId \n"
//            + "and p.playerName like :#{#paramPlayer.familyName} \n"
//            + "and p.height >= :#{#paramPlayer.height}")
//    List<Player> findPlayers(@Param(value = "paramPlayer") Player player, @Param(value = "paramPlayer") String teamId);


}
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>, PlayerCustomRepository {
}
