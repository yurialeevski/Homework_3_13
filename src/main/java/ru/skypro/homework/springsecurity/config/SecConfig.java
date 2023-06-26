package ru.skypro.homework.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecConfig {
    //@Autowired
    //public DataSource dataSource;

    /*@Bean
    // Создаем бин authenticationManager и получаем его из AuthenticationConfiguration.
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }*/
    /*@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource,
                                                 AuthenticationManager authenticationManager) {
        // Инициализируем JdbcUserDetailsManager с dataSourc и authenticationManager для работы с базой данных
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        jdbcUserDetailsManager.setAuthenticationManager(authenticationManager);
        return jdbcUserDetailsManager;
    }*/

    //@Bean
    // Создаем бин кодировщика паролей (для хеширования паролей пользователей)
    //public PasswordEncoder passwordEncoder() {
    //    return new BCryptPasswordEncoder();
    //}

    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/*"))
                .authorizeHttpRequests(this::customizeRequest)
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());
        return http.build();
    }
    private void customizeRequest(
            AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
        try {
            registry.requestMatchers(new AntPathRequestMatcher("/admin/**")).hasAnyRole("ADMIN")
                    .requestMatchers(new AntPathRequestMatcher("/**")).hasAnyRole("USER")
                    .and()
                    .formLogin().permitAll() // Позволяем всем пользователям доступ к форме входа.
                    .and()
                    .logout().logoutUrl("/logout"); // Настраиваем механизм выхода из системы с заданием URL "/logout".

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}
