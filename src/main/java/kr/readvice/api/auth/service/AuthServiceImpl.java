package kr.readvice.api.auth.service;

import kr.readvice.api.user.domains.User;
import kr.readvice.api.user.repositories.UserRepository;
import kr.readvice.api.auth.domains.Auth;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName: kr.readvice.api.security.domains
 * fileName        : UserDetailsServiceImpl
 * author           : 하진희
 * date               : 2022-05-23
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-23         하진희        최초 생성
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements UserDetailsService {
    // Reference
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(()-> new UsernameNotFoundException(username+ "에 해당하는 객체가 존재하지 않습니다."));
        return Auth.build(user.get());
    }
}
