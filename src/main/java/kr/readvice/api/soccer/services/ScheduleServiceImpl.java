package kr.readvice.api.soccer.services;

import kr.readvice.api.soccer.domains.Schedule;
import kr.readvice.api.soccer.repositories.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository repository;

    @Override
    public List<Schedule> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Schedule> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Schedule> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(Schedule schedule) {
        repository.delete(schedule);
        return "";
    }

    @Override
    public String save(Schedule schedule) {
        repository.save(schedule);
        return null;
    }

    @Override
    public Optional<Schedule> findById(String scheduleNo) {
        return repository.findById(0L);
    }

    @Override
    public boolean existsById(String scheduleNo) {
        return repository.existsById(0L);
    }

    @Override
    public String update(Schedule schedule) {
        return "";
    }
}
