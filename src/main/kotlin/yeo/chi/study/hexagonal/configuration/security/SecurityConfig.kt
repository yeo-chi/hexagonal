package yeo.chi.study.hexagonal.order.configuration.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy.STATELESS

@Configuration
class SecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity) = http
        .csrf { it.disable() }
        .headers {
            it.frameOptions { frameOptions ->
                frameOptions.sameOrigin()
            }
        }
        .authorizeHttpRequests {
            it.requestMatchers(
                "/",
                "/swagger-ui/**",
                "/v3/**",
            ).permitAll()
                .anyRequest()
                .authenticated()
        }
        .sessionManagement { it.sessionCreationPolicy(STATELESS) }
        .build()
}
