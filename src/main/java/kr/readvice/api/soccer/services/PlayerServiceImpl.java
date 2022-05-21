package kr.readvice.api.soccer.services;

import kr.readvice.api.common.dataStructure.Box;
import kr.readvice.api.soccer.domains.Player;
import kr.readvice.api.soccer.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository repository;


    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Player> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Player> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(Player player) {
        repository.delete(player);
        return "";
    }

    @Override
    public String save(Player player) {
        repository.save(player);
        return null;
    }

    @Override
    public Optional<Player> findById(String playerid) {
        return repository.findById(0L);
    }

    @Override
    public boolean existsById(String playerid) {
        return repository.existsById(0L);
    }

    @Override
    public String update(Player player) {
        return "";    }

}
