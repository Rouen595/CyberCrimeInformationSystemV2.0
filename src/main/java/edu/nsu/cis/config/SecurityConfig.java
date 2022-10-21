package edu.nsu.cis.config;

import edu.nsu.cis.security.CustomAccessDeniedHandler;
import edu.nsu.cis.security.CustomAuthenticationFailureHandler;
import edu.nsu.cis.security.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@ComponentScan(basePackages = { "edu.nsu.cis.security" })
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("cisUser")
                .password(passwordEncoder().encode("cisUser"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("cisAdmin")
                .password(passwordEncoder().encode("cisAdmin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests()
                    .mvcMatchers("/", "index.html", "/about", "/static/**", "/resources/**", "/webjars/**").permitAll()
                    .mvcMatchers("/home.html", "/search.html").hasRole("USER")
                    .mvcMatchers("/admin/admin.html").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                //.failureHandler(authenticationFailureHandler())
                .and()
                .logout().permitAll()
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler())
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and().build();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

}