package kr.readvice.api.board.services;

import kr.readvice.api.board.domains.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.readvice.api.board.services
 * fileName        : BoardService
 * author           : 하진희
 * date               : 2022-05-20
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-20         하진희        최초 생성
 */
public interface BoardService {


    String update(Board board);

    List<Board> findAll();

    List<Board> findAll(Sort sort);

    Page<Board> findAll(Pageable pageable);

    long count();

    String delete(Board board);

    String save(Board board);

    Optional<Board> findById(String boardid);

    boolean existsById(String boardid);
}
