package kr.readvice.api.board.repositories;

import kr.readvice.api.board.domains.Article;
import kr.readvice.api.board.domains.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName: kr.readvice.api.board.repositories
 * fileName        : BoardRepository
 * author           : 하진희
 * date               : 2022-05-20
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-20         하진희        최초 생성
 */

interface BoardCustomRepository{
// 000. 게시판 이름 boardName 을 변경하시오

}
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
