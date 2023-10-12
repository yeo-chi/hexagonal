package yeo.chi.study.hexagonal.configuration.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
data class JwtConfiguration(
    val secretKey: String,

    val expirationSecond: Long,

    val issuer: String,
)
