package kr.readvice.api.soccer.controllers;

import kr.readvice.api.soccer.domains.Player;
import kr.readvice.api.soccer.domains.Schedule;
import kr.readvice.api.soccer.domains.Stadium;
import kr.readvice.api.soccer.services.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stadiums")
public class StadiumController {
    private final StadiumService service;

    @PutMapping("/update")
    public String update(@RequestBody Stadium stadium) {
        return service.update(stadium);
    }

    @GetMapping("/findAll")
    public List<Stadium> findAll(){
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<Stadium> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Stadium> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Stadium stadium) {
        return service.delete(stadium);
    }

    @PostMapping("/save")
    public String save(@RequestBody Stadium stadium) {
        return service.save(stadium);
    }

    @GetMapping("/findById/{stadiumid}")
    public Optional<Stadium> findById(@PathVariable String stadiumid) {
        return service.findById(stadiumid);
    }

    @GetMapping("/existsById/{stadiumid}")
    public boolean existsById(@PathVariable String stadiumid) {
        return service.existsById(stadiumid);
    }

    @GetMapping("/findByName/{stadiumname}")
    public List<Stadium> findByName(@PathVariable String stadiumname) {
        return service.findByName(stadiumname);
    }

}
