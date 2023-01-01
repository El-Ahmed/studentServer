package ma.ac.emi.studentserver.services;

import ma.ac.emi.studentserver.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.stereotype.Component;

@Component
public class JWTHttpConfigurer extends AbstractHttpConfigurer<JWTHttpConfigurer, HttpSecurity> {

    private final JwtTokenUtil jwtTokenUtils;

    public JWTHttpConfigurer(JwtTokenUtil jwtTokenUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @Override
    public void configure(HttpSecurity http) {
        http.securityMatcher("/graphql").addFilter(new JwtRequestFilter());
    }

}
