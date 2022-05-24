package kr.readvice.api.security.domains;

import com.sun.istack.NotNull;
import kr.readvice.api.auth.domains.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.awt.font.ShapeGraphicAttribute;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: kr.readvice.api.security.domains
 * fileName        : UserDetailsImpl
 * author           : 하진희
 * date               : 2022-05-23
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-23         하진희        최초 생성
 */
@Getter
@RequiredArgsConstructor

public class UserDetailsImpl implements UserDetails {
    private final long userid;
    private final String username;
    @JsonIgnore private final String password;
    private final String name;
    private final String email;


    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(user.getUserId(), user.getUsername(), user.getPassword(),
                user.getName(), user.getEmail(), authorities
        );
    }

    private final Collection<? extends GrantedAuthority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
