package kr.readvice.api.soccer.controllers;

import kr.readvice.api.soccer.domains.Player;
import kr.readvice.api.soccer.domains.Schedule;
import kr.readvice.api.soccer.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService service;

    @PutMapping("/update")
    public String update(@RequestBody Schedule schedule) {
        return service.update(schedule);
    }
    @GetMapping("/findAll")
    public List<Schedule> findAll(){
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<Schedule> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Schedule> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Schedule schedule) {
        return service.delete(schedule);
    }

    @PostMapping("/save")
    public String save(@RequestBody Schedule schedule) {
        return service.save(schedule);
    }

    @GetMapping("/findById/{scheduleNo}")
    public Optional<Schedule> findById(@PathVariable String scheduleNo) {
        return service.findById(scheduleNo);
    }

    @GetMapping("/existsById/{scheduleNo}")
    public boolean existsById(@PathVariable String scheduleNo) {
        return service.existsById(scheduleNo);
    }




}
