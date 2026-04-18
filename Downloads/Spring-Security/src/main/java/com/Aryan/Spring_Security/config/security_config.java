package com.Aryan.Spring_Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity // to change the configuration of the web security
public class security_config {

    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http.csrf(customizer -> customizer.disable());
        // desable to block any request that can mlodify the page
        http.authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated());
           // this tells any request need to go to the authoriztion process first

        //http.formLogin(Customizer.withDefaults()); // default login page is there
        http.httpBasic(Customizer.withDefaults()); // for the postmen

        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // no need for the token number to enter the data  v
        // always a new session id is created
         return http.build();
    }

}
