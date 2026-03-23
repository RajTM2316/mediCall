package com.raj.medicall.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // JDBC Authentication

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager =
                new JdbcUserDetailsManager(dataSource);

        // query to fetch user
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select email, password, is_active from app_user where email=?"
        );

        // query to fetch roles
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select u.email, r.name " +
                        "from app_user u join roles r on u.role_id=r.id " +
                        "where u.email=?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer

                        .requestMatchers("/auth/**").permitAll()

                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        .requestMatchers("/doctor/**").hasRole("DOCTOR")

                        .requestMatchers("/patient/**").hasRole("PATIENT")

                        .anyRequest().authenticated()
        );

        // Basic Auth (same as example)
        http.httpBasic(Customizer.withDefaults());

        // disable csrf for REST
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}