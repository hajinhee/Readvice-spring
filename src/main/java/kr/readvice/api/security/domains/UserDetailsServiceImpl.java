package kr.readvice.api.security.domains;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
