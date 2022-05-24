package kr.readvice.api.soccer.services;

import kr.readvice.api.common.dataStructure.Box;
import kr.readvice.api.soccer.domains.Team;
import kr.readvice.api.soccer.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository repository;

    @Override
    public List<Team> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Team> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Team> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(Team team) {
        repository.delete(team);
        return "";
    }

    @Override
    public String save(Team team) {
        repository.save(team);
        return null;
    }

    @Override
    public Optional<Team> findById(String teamid) {
        return repository.findById(0L);
    }

    @Override
    public boolean existsById(String teamid) {
        return repository.existsById(0L);
    }

    @Override
    public List<Team> findByName(String teamname) {
        List<Team> ls = repository.findAll();
        Box<String, Team> box = new Box<>();
        return null;
    }

    @Override
    public String update(Team team) {
        return "";
    }
}
