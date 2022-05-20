package kr.readvice.api.board.controllers;

import kr.readvice.api.board.domains.Article;
import kr.readvice.api.board.domains.Board;
import kr.readvice.api.board.services.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.readvice.api.auth.controllers
 * fileName        : BoardController
 * author           : 하진희
 * date               : 2022-05-20
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-20         하진희        최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;

    @PutMapping("/update")
    public String update(@RequestBody Board board) {
        return service.update(board);
    }

    // Embeded Methods
    @GetMapping("/findAll")
    public List<Board> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<Board> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Board> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Board board) {
        return service.delete(board);
    }

    @PostMapping("/save")
    public String save(@RequestBody Board board) {
        return service.save(board);
    }

    @GetMapping("/findById/{boardid}")
    public Optional<Board> findById(@PathVariable String boardid) {
        return service.findById(boardid);
    }

    @GetMapping("/existsById/{boardid}")
    public boolean existsById(@PathVariable String boardid) {
        return service.existsById(boardid);
    }

}
