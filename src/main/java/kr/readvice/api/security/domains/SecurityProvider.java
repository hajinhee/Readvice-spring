package kr.readvice.api.security.domains;

import kr.readvice.api.auth.domains.Role;
import kr.readvice.api.security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.List;

/**
 * packageName: kr.readvice.api.security.domains
 * fileName        : SecurityProvider
 * author           : 하진희
 * date               : 2022-05-23
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-23         하진희        최초 생성
 */
@Log
@Component
@RequiredArgsConstructor
public class SecurityProvider implements AuthenticationProvider {
    private final UserDetailsServiceImpl service;

    // Value = 외부에서 주입되는 값
    @Value("${security.jwt.token.security-key:secret-key}")
    private String securityKey;

    @Value("${security.jwt.token.expiration-length:3600000}")
    private long validityInMs = 3600000;

    @PostConstruct
    protected void  init(){
        securityKey = Base64.getEncoder().encodeToString(securityKey.getBytes());
        log.info("securityKey: " +securityKey);
    }

    public String createToken(String username, List<Role> role){
        return "";
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
