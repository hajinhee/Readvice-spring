package kr.readvice.api.controllers;

import kr.readvice.api.domains.User;
import kr.readvice.api.services.UserService;
import kr.readvice.api.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor // 컨트롤러(자식)-서비스(부모) 연결, 리액트에서의 props
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return service.login(user);
    }
    @GetMapping("/logout") //파라미터가 없으면 Get?
    public String logout(){
        return "";
    }
    @GetMapping("/findAll")  //find 라는 이름은 무조건 @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<User> findAll(Sort sort) {
        return service.findAll(sort);
    }
    @GetMapping("/findAll/pageable")
    public Page<User> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    @GetMapping("/count") //count => @GetMapping
    public long count() {
        return service.count();
    }
    @PutMapping("/put") //count => @GetMapping
    public String put(@RequestBody User user) {
        service.put(user);
        return "";
    }
    @DeleteMapping("/delete") //delete => @DeleteMapping
    public String delete(@RequestBody User user) {
        return service.delete(user);
    }
    @PostMapping("/join") //save=join
    public String save(@RequestBody User user) {
        service.save(user);
        return "";
    }
    @GetMapping("/findById/{userid}") //Path=url variable={변수}
    public Optional<User> findById(@PathVariable String userid) {
        return service.findById(userid);
    }

    @GetMapping("/existsById/{userid}")
    public boolean existsById(@PathVariable String userid) {
        return service.existsById(userid);
    }

}
