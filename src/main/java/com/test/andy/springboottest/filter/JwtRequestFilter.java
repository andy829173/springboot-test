package com.test.andy.springboottest.filter;

import com.test.andy.springboottest.service.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException; // 處理 JWT 過期異常
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.context.SecurityContextHolder; // 引入 SecurityContextHolder，用於存取安全上下文
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource; // 構建Web認證詳細信息
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter { // 繼承 OncePerRequestFilter，確保過濾器在每個請求中只執行一次

    @Autowired
    private UserDetailsService userDetailsService; // 加載用戶詳細信息

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization"); // 從請求頭中獲取 Authorization 標頭

        String username = null;
        String jwtToken = null;

        // JWT Token 以 "Bearer token" 格式提供。移除 Bearer 前綴並獲取 Token
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtUtil.extractUsername(jwtToken); // 從 Token 中提取用戶名
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token"); // 無法獲取 JWT Token
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired"); // JWT Token已過期
            }
        } else {
            System.out.println("JWT Token does not begin with Bearer String"); // JWT Token 沒有以 Bearer 開頭
        }

        // 當Token獲取到用戶名後，並且安全上下文中沒有驗證信息時，進行驗證
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username); // 從UserDetailsService加載用戶詳細信息

            // 如果Token有效，配置Spring Security以手動設置驗證
            if (jwtUtil.validateToken(jwtToken, userDetails.getUsername())) {

                // 構建用戶名和密碼的驗證令牌
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // 設置驗證的詳細信息

                // 設置安全上下文中的驗證信息，表示當前用戶已驗證
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response); // 將請求傳遞給過濾器鏈中的下一個過濾器
    }
}
