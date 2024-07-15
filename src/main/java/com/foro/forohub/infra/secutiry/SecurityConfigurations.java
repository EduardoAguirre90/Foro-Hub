package com.foro.forohub.infra.secutiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration      //configuracion
@EnableWebSecurity  //habilita websecurity para esta configuracion
public class SecurityConfigurations{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable) // Deshabilita CSRF
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configura la política de gestión de sesiones
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception{
        return  authenticationConfiguration.getAuthenticationManager();
    }



//    @Autowired
//    private SecurityFilter securityFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(sessionManagement -> sessionManagement
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //le indicamos a spring el tipo de sesion
//                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                        .requestMatchers(HttpMethod.POST, "/login")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated())
//                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//            throws Exception{
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
    @Bean
    public PasswordEncoder PaswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
