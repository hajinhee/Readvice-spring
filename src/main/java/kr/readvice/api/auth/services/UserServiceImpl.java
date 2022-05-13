package kr.readvice.api.auth.services;

import kr.readvice.api.auth.domains.User;
import kr.readvice.api.auth.repositories.UserRepository;
import kr.readvice.api.common.dataStructure.Box;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // 서비스(자식)-레파지토리(부모) 연결, prop가 있으면 자식 컴포넌트
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    @Override
    public String login(User user) {
        return repository.login(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String put(User user) {
        repository.put(user);
        return "";
    }

    @Override
    public String delete(User user) {
        repository.delete(user);
        return "";
    }

    @Override
    public String save(User user) {
        repository.save(user);
        return null;
    }

    @Override
    public Optional<User> findById(String userid) {
        return repository.findById(0L); // userid 타입이 다름

    }

    @Override
    public boolean existsById(String userid) {
        return repository.existsById(0L); // userid 타입이 다름

    }

    @Override
    public List<User> findByUserName(String name) {
        List<User> ls = repository.findAll();
        Box<String, User> box = new Box<>();
//        ls = box.findByUserName(ls, name);
//        ls.stream().filter(...)
        return null;
    }
}
