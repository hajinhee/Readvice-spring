package kr.readvice.api.soccer.controllers;

import kr.readvice.api.soccer.domains.Player;
import kr.readvice.api.soccer.domains.Schedule;
import kr.readvice.api.soccer.domains.Stadium;
import kr.readvice.api.soccer.domains.Team;
import kr.readvice.api.soccer.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamController {
    private final TeamService service;
    @PutMapping("/update")
    public String update(@RequestBody Team team) {
        return service.update(team);
    }

    @GetMapping("/findAll")
    public List<Team> findAll(){
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<Team> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Team> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Team team) {
        return service.delete(team);
    }

    @PostMapping("/save")
    public String save(@RequestBody Team team) {
        return service.save(team);
    }

    @GetMapping("/findById/{teamid}")
    public Optional<Team> findById(@PathVariable String teamid) {
        return service.findById(teamid);
    }

    @GetMapping("/existsById/{teamid}")
    public boolean existsById(@PathVariable String teamid) {
        return service.existsById(teamid);
    }

    @GetMapping("/findByName/{teamname}")
    public List<Team> findByName(@PathVariable String teamname) {
        return service.findByName(teamname);
    }


}
