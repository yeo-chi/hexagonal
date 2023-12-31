package yeo.chi.study.hexagonal.configuration.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy.STATELESS
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import yeo.chi.study.hexagonal.configuration.jwt.JwtAuthenticationFilter

@Configuration
class SecurityConfiguration(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter,
) {
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
                "/**",
                "/api/v1/users/**",
                "/swagger-ui/**",
                "/v3/**",
            ).permitAll()
                .anyRequest()
                .authenticated()
        }
        .sessionManagement { it.sessionCreationPolicy(STATELESS) }
        .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter::class.java)
        .build()

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}
