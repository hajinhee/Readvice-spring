package kr.readvice.api.auth.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName: kr.readvice.api.auth.filter
 * fileName        : AuthEntryPoint
 * author           : 하진희
 * date               : 2022-05-25
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-25         하진희        최초 생성
 */
@RequiredArgsConstructor
public class AuthEntryPoint implements AuthenticationEntryPoint {
    private final HandlerExceptionResolver resolver;
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        resolver.resolveException(request, response, null, authException);
    }
}
