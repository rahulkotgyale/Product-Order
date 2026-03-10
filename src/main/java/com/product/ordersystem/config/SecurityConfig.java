package com.product.ordersystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth

                // ADMIN APIs
                .requestMatchers("/api/products").hasRole("ADMIN")
                .requestMatchers("/api/products/**").hasRole("ADMIN")

                // USER APIs
                .requestMatchers("/api/cart/**").hasRole("USER")
                .requestMatchers("/api/orders/**").hasRole("USER")

                // PUBLIC APIs
                .requestMatchers("/api/products", "/api/products/*").permitAll()

                .anyRequest().authenticated()
        )
        .formLogin(Customizer.withDefaults());  // ✅ FIX

        return http.build();
    }
}