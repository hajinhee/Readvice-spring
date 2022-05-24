package kr.readvice.api.auth.configs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.readvice.api.auth.domains.Auth;
import kr.readvice.api.user.domains.Role;
import kr.readvice.api.auth.service.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
public class AuthProvider implements AuthenticationProvider {
    private final AuthServiceImpl service;

    // Value = 외부에서 주입되는 값
    @Value("secret-key")
    private String securityKey;

    @Value("3600000")
    private long validityInMs = 3600000;

    @PostConstruct
    protected void  init(){
        securityKey = Base64.getEncoder().encodeToString(securityKey.getBytes());
        log.info("securityKey: " +securityKey);
    }

    public String createToken(String username, List<Role> roles){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
        Date now = new Date();
        Date validity = new Date(now.getTime()+validityInMs);
        return Jwts.builder().setClaims(claims).setIssuedAt(now)
                .setExpiration(validity).signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();
    }
    public Authentication getAuthentication(String token){
        UserDetails auth = service.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(auth.getAuthorities(), "", auth.getAuthorities());
    }
    public String getUsername(String token){
        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody()
                .getSubject();
    }
    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer")){
            return bearerToken.substring(7);
        }
        return null;
    }
    public boolean validateToken(String token) throws Exception{
        try{
            Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token);
            return true;
        }catch (JwtException | IllegalArgumentException e){
            throw new Exception();
        }
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
