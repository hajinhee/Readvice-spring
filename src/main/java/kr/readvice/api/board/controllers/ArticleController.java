package kr.readvice.api.board.controllers;

import kr.readvice.api.board.domains.Article;
import kr.readvice.api.board.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.readvice.api.board.controllers
 * fileName        : ArticleController
 * author           : 하진희
 * date               : 2022-05-20
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-20         하진희        최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService service;

    @PutMapping("/update")
    public String update(@RequestBody Article article) {
        return service.update(article);
    }

    // Embeded Methods
    @GetMapping("/findAll")
    public List<Article> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<Article> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Article> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Article article) {
        return service.delete(article);
    }

    @PostMapping("/save")
    public String save(@RequestBody Article article) {
        return service.save(article);
    }

    @GetMapping("/findById/{articleid}")
    public Optional<Article> findById(@PathVariable String articleid) {
        return service.findById(articleid);
    }

    @GetMapping("/existsById/{articleid}")
    public boolean existsById(@PathVariable String articleid) {
        return service.existsById(articleid);
    }


}
