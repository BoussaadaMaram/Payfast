package com.paymentqrcode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Méthode pour configurer les règles de sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()  // Désactive la protection CSRF (utile pour les tests)
                .authorizeRequests()
                .requestMatchers("/api/users/register").permitAll()  // Permet l'accès à l'enregistrement sans authentification
        ;  // Authentifie toutes les autres requêtes

        return http.build();
    }

    // Bean pour le PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Utilise BCrypt pour le hachage du mot de passe
    }
}
