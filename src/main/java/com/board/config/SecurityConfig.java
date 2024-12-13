//package com.board.config;
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();  // CSRF 보호 비활성화
////        http.formLogin(config -> {
////            config.loginPage("/user/login").loginProcessingUrl("/user/login")
////                    .usernameParameter("userName")
////                    .passwordParameter("userPassword")
////                    .defaultSuccessUrl("/board");
////        });
////
////        http.logout(config -> {
////            config.logoutUrl("/logout").logoutSuccessUrl("/login");
////        });
////
////        http.authorizeHttpRequests(registry -> {
////            registry.requestMatchers("/user/login", "/user/signup").permitAll();
////            registry.anyRequest().authenticated();
////        });
////         권한 설정: DELETE 요청은 ADMIN만 가능
//        http.authorizeHttpRequests(registry -> {
//            registry.requestMatchers("/*").permitAll();
//            registry.requestMatchers(HttpMethod.DELETE, "/board/*/delete").permitAll();  // DELETE 요청에 대한 권한 설정
//            registry.anyRequest().permitAll();  // 다른 요청은 인증된 사용자만 가능
//        });
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }
//
//}