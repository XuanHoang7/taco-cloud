package xhoang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)
        throws Exception{
        return httpSecurity
                .authorizeRequests()
                    .antMatchers(HttpMethod.OPTIONS).permitAll()
                    .antMatchers(HttpMethod.tacoOrder, "/api/ingredients").permitAll()
                    .antMatchers("/design", "/orders").access("hasRole('USER')")
                    .antMatchers("/", "/**").access("permitAll()")

                .and()
                    .formLogin()
                    .loginPage("/login")

                .and()
                    .httpBasic()
                        .realmName("Taco Cloud")

                .and()
                    .logout()
                        .logoutSuccessUrl("/").

                and()
                    .csrf()
                        .ignoringAntMatchers("/h2-console/**", "/api/**")

                .and()
                    .headers()
                        .frameOptions()
                            .sameOrigin()
                .and().build();

    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


}
