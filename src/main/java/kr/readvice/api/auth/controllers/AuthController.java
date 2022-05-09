package kr.readvice.api.auth.controllers;

import kr.readvice.api.auth.domains.User;
import kr.readvice.api.auth.services.AuthService;
import kr.readvice.api.auth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;

    @PostMapping("/login")
    public String login(@RequestBody){
        return service.login();
    }
    @GetMapping("/logout") //파라미터가 없으면 Get?
    public String logout(){
        return "";
    }
}
