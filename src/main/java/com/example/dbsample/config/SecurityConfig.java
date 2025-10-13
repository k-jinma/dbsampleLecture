package com.example.dbsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  // パスワードの暗号化
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  InMemoryUserDetailsManager userDetailsService() {
    // 管理者設定
    UserDetails admin = User
        .withUsername("admin")
        .password(passwordEncoder().encode("admin"))
        .roles("ADMIN")
        .build();

    // ユーザー設定
    UserDetails user = User
        .withUsername("user")
        .password(passwordEncoder().encode("user"))
        .roles("USER")
        .build();
        
    return new InMemoryUserDetailsManager(admin, user);
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.formLogin(login -> login //  フォーム認証を使う
        .permitAll())
        .authorizeHttpRequests(authz -> authz
            //.requestMatchers("/css/**").permitAll() // CSSファイルは認証不要で使えるようにする
            //.requestMatchers("/").permitAll() //  トップページは認証
            .anyRequest().authenticated() //  他のURLはログイン後アクセス可能
        );

    return http.build();
  }

}