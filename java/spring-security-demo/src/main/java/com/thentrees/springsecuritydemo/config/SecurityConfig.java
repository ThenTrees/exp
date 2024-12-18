package com.thentrees.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // active spring web security
@EnableMethodSecurity(jsr250Enabled = true) // active method security
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/api/v1/auth/login", "/api/v1/auth/register").permitAll()
                        .requestMatchers("/admin/vip").hasRole("ADMIN")
                        .requestMatchers("/admin/normal").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()
                );
        // tach be voi fe
        http.formLogin(formLogin -> formLogin.loginProcessingUrl("/login"));
        return http.build();
    }

    /**
     * Config user detail information
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
//                .roles("ADMIN", "USER") // auto add prefix ROLE_
                .authorities("ROLE_ADMIN", "ROLE_USER", "order:read", "order:write") // no prefix ROLE_, nen su dung
                .build();


        UserDetails user = User.withUsername("user")
                .username("user")
                .password(passwordEncoder().encode("user"))
//                .roles("USER")
                .authorities("ROLE_USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
