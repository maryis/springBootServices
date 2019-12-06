package com.example.viewWithSecurity;

import com.example.viewWithSecurity.exception.AuthFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("userDetailsServiceImp")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//
//        System.out.println("i am here");
//        http.authorizeRequests()
//                .antMatchers("/register/**", "/login/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/", true)
//                .failureUrl("/pub/error")
//                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
//                .and()
//                .exceptionHandling().accessDeniedPage("/pub/error")
//                .and()
//                .logout()
//                .permitAll()
//                .invalidateHttpSession(true)
////                .logoutRequestMatcher(new AntPathRequestMatcher("/pub/logout"))
//                .logoutSuccessUrl("/login").permitAll();

        http
                .authorizeRequests()
                .antMatchers("/actuator/**", "/register", "/error","/checkexc").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/", true)
                //.failureUrl("/error")
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .permitAll()
                .and()
                //always use following codes to get detailed error instead of 403:forbidden
                //if we set /error, no detailed error page(whiteable..) has been seen
                .cors()
                .and()
                .csrf().disable();
    }


    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new AuthFailureHandler();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}
