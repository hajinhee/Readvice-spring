package kr.readvice.api.security.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * packageName: kr.readvice.api.config
 * fileName        : WebSecurityConfig
 * author           : 하진희
 * date               : 2022-05-23
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-23         하진희        최초 생성
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "*/**")
                .antMatchers("/");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 로그인 없이 허용하는 링크
        http.authorizeRequests()
                .antMatchers("/users/join").permitAll()
                .antMatchers("/users/login").permitAll()
                .anyRequest().authenticated();
        // 그 외에는 모두 로그인을 해야하므로 로그인 화면으로 이동
        http.exceptionHandling().accessDeniedPage("/users/login"
        );
    }
}
