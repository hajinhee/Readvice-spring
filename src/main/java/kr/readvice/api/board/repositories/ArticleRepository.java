package kr.readvice.api.board.repositories;

import kr.readvice.api.board.domains.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName: kr.readvice.api.board.repositories
 * fileName        : ArticleRepository
 * author           : 하진희
 * date               : 2022-05-20
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-20         하진희        최초 생성
 */
interface ArticleCustomRepository{
    // 000. title 과 content 를 수정하시오
    Article update(Article article);}


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
