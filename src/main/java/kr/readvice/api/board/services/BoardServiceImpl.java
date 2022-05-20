package kr.readvice.api.board.services;

import kr.readvice.api.board.domains.Board;
import kr.readvice.api.board.repositories.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.readvice.api.auth.services
 * fileName        : BoardServiceImpl
 * author           : 하진희
 * date               : 2022-05-20
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-20         하진희        최초 생성
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository repository;

    @Override
    public String update(Board board) {
        
        return "";
    }

    @Override
    public List<Board> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Board> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Board> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(Board board) {
        repository.delete(board);
        return "";
    }

    @Override
    public String save(Board board) {
        repository.save(board);
        return null;
    }

    @Override
    public Optional<Board> findById(String boardid) {
        return repository.findById(0L);
    }

    @Override
    public boolean existsById(String boardid) {
        return repository.existsById(0L);
    }
}
