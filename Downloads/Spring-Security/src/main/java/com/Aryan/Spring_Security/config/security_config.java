package com.Aryan.Spring_Security.config;

import com.Aryan.Spring_Security.service.MyUserDetailSeavice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // to change the configuration of the web security
public class security_config {

    @Autowired
    private MyUserDetailSeavice userDetailService;

    @Bean // used to tell the spring take the configuration from here
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http.csrf(customizer -> customizer.disable());
        // desable to block any request that can mlodify the page
        http.authorizeHttpRequests(customizer -> customizer

                // for these url there is no id and password is required we can directly access them
                .requestMatchers("login","register")
                .permitAll()


                .anyRequest()
                .authenticated());
        // this tells any request need to go to the authoriztion process first

        // http.formLogin(Customizer.withDefaults()); // default login page is there
        http.httpBasic(Customizer.withDefaults()); // for the postmen

        http.sessionManagement(  session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // no need for the token number to enter the data v
        // always a new session id is created
        return http.build();
    }

    @Bean
    public AuthenticationProvider auth(){
        DaoAuthenticationProvider  provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        // this line is used to decrypt the password while getting the password
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticManage(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();

    }

}
