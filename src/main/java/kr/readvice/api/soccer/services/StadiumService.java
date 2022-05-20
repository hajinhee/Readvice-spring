package kr.readvice.api.soccer.services;

import kr.readvice.api.soccer.domains.Player;
import kr.readvice.api.soccer.domains.Stadium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface StadiumService {
    List<Stadium> findAll();

    List<Stadium> findAll(Sort sort);

    Page<Stadium> findAll(Pageable pageable);

    long count();

    String delete(Stadium stadium);

    String save(Stadium stadium);

    Optional<Stadium> findById(String stadiumid);

    boolean existsById(String stadiumid);

    // custom

    List<Stadium> findByName(String stadiumname);

    String update(Stadium stadium);
}
