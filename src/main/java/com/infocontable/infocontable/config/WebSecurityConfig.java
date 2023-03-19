package com.infocontable.infocontable.config;

import com.infocontable.infocontable.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;

    @Autowired
    private CustomAuthSuccessHandler customAuthSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/*","/js/*","/img/*").permitAll()
//                .anyRequest().authenticated()
                .and()
                .userDetailsService(jpaUserDetailsService)
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/logincheck").usernameParameter("nit").passwordParameter("password")
                .failureUrl("/login?error=true")
                .successHandler(customAuthSuccessHandler).permitAll()
                .and().build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

}



