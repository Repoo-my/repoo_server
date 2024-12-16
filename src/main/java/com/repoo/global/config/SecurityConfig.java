package com.repoo.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.repoo.auth.domain.repository.RefreshTokenRepository;
import com.repoo.global.exception.ErrorResponse;
import com.repoo.global.exception.security.RepooSecurityException;
import com.repoo.global.exception.security.RepooSecurityExceptionFilter;
import com.repoo.global.jwt.exception.CustomAccessDeniedException;
import com.repoo.global.jwt.exception.UnauthenticatedAccessException;
import com.repoo.global.jwt.filter.CustomJwtFilter;
import com.repoo.global.jwt.filter.CustomLogoutFilter;
import com.repoo.global.jwt.filter.LoginFilter;
import com.repoo.global.jwt.util.JwtUtil;
import com.repoo.oauth.handler.CustomSuccessHandler;
import com.repoo.oauth.service.CustomOAuth2UserService;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;
    private final ObjectMapper objectMapper;
    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomSuccessHandler customSuccessHandler;

    private final List<String> excludedPaths = Arrays.asList("/login","/auth/**", "/reissue","/swagger-ui/**", "/v3/api-docs/**", "/api/**", "/verify", "/favicon.ico", "/logout");

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors((cors) -> cors
                                .configurationSource(request -> {

                                    CorsConfiguration configuration = new CorsConfiguration();
                                    configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
                                    configuration.setAllowedMethods(Collections.singletonList("*"));
                                    configuration.setAllowCredentials(true);
                                    configuration.setAllowedHeaders(Collections.singletonList("*"));
                                    configuration.setMaxAge(3600L);
                                    configuration.setExposedHeaders(Arrays.asList("Set-Cookie", "Authorization"));

                                    return configuration;
                                })
                );

        http
                .csrf((auth) -> auth.disable());

        http
                .formLogin((auth) -> auth.disable());

        http
                .httpBasic((auth) -> auth.disable());

        http
                .oauth2Login((oauth2) -> oauth2
                        .userInfoEndpoint((userInfoEndpointConfig) -> userInfoEndpointConfig
                                .userService(customOAuth2UserService))
                        .successHandler(customSuccessHandler)
                        .failureHandler((request, response, exception) -> {
                            if (exception instanceof RepooSecurityException) {
                                RepooSecurityException e = (RepooSecurityException) exception;
                                response.setStatus(e.getStatus().value());
                                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                                response.setCharacterEncoding(StandardCharsets.UTF_8.name());

                                ErrorResponse errorResponse = ErrorResponse.from(
                                        e.getStatus().value(),
                                        e.getErrorCode(),
                                        e.getMessage()
                                );
                                log.warn("소셜 스페이스 익셉션 동작");
                                response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
                            } else {
                                response.sendRedirect("/login?error");
                            }
                        }));

        http
                .logout((auth) -> auth.disable());

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/oauth2/**","/auth/**", "/login/**", "/reissue","/swagger-ui/**", "/v3/api-docs/**", "/api/**", "/verify", "/favicon.ico", "/logout").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/users").permitAll()
                        .requestMatchers(HttpMethod.POST,"/users").hasRole("GUEST")
                        .anyRequest().hasRole("USER"));

        http
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint(((request, response, e) -> {
                            throw new UnauthenticatedAccessException();
                        }))
                        .accessDeniedHandler((request, response, e) -> {
                            throw new CustomAccessDeniedException();
                        })
                );

        http
                .addFilterAfter(new RepooSecurityExceptionFilter(objectMapper), CorsFilter.class);

        http
                .addFilterAfter(new CustomJwtFilter(jwtUtil, excludedPaths), CorsFilter.class);

        http
                .addFilterBefore(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil, objectMapper), UsernamePasswordAuthenticationFilter.class);

        http
                .addFilterAt(new CustomLogoutFilter(jwtUtil, refreshTokenRepository), LogoutFilter.class);

        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

}
