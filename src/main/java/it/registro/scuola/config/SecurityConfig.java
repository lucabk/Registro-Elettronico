package it.registro.scuola.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
            //disable CSRF
            .csrf(AbstractHttpConfigurer::disable)

            //authentication is required for each request
            .authorizeHttpRequests(request -> request.anyRequest().authenticated())

            //enable login (with default Spring Security properties) from REST client
            .httpBasic(Customizer.withDefaults())

            //http stateless => new session each req => need credentials for each req
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            .build();
    }
}
