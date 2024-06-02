package com.test.andy.springboottest.config;

import com.test.andy.springboottest.filter.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager; // 管理認證
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration; // 配置認證管理器
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // 配置 HTTP 安全性
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // 啟用 Web 安全性
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer; // 禁用 CSRF 保護
import org.springframework.security.core.userdetails.User; // 創建用戶詳細信息
import org.springframework.security.core.userdetails.UserDetailsService; // 加載用戶詳細信息的服務接口
import org.springframework.security.provisioning.InMemoryUserDetailsManager; // 內存中存儲用戶詳細信息
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // BCrypt 密碼編碼
import org.springframework.security.crypto.password.PasswordEncoder; // 用於密碼編碼和匹配
import org.springframework.security.web.SecurityFilterChain; // 配置應用程序的安全過濾器鏈
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; // 處理基於用戶名和密碼的身份驗證過濾器
import org.springframework.security.config.http.SessionCreationPolicy; // 設置會話創建策略

@Configuration
@EnableWebSecurity // 啟用 Spring Security 的 Web 安全支持
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 配置HTTP安全性
        http.csrf(AbstractHttpConfigurer::disable) // 禁用 CSRF 保護
                .authorizeRequests(auth -> auth
                        .requestMatchers("/login").permitAll() // 設置 /login 路徑可匿名訪問
                        .anyRequest().authenticated() // 其他所有路徑都需要身份驗證
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 設置會話管理策略為無狀態，即不使用 HTTP 會話
                );

        // 在 UsernamePasswordAuthenticationFilter 之前添加 JWT 過濾器
        http.addFilterBefore(new JwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build(); // 構建並返回 SecurityFilterChain 對象
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 創建一個內存中存儲的用戶詳細信息管理器
        return new InMemoryUserDetailsManager(
                User.withUsername("user") // 設置用戶名
                        .password(passwordEncoder().encode("password")) // 設置加密後的密碼
                        .roles("USER") // 設置用戶角色
                        .build() // 構建User對象
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 返回一個 BCryptPasswordEncoder 對象，用於密碼編碼
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager(); // 從 AuthenticationConfiguration 中獲取並返回 AuthenticationManager 對象
    }
}
