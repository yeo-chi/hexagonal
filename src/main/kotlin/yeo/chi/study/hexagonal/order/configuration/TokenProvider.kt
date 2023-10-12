package yeo.chi.study.hexagonal.order.configuration

import io.jsonwebtoken.Jwts
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime.now
import java.time.temporal.ChronoUnit
import java.util.*
import javax.crypto.spec.SecretKeySpec

@ConfigurationProperties("jwt")
@Service
class TokenProvider(
    private val secretKey: String,

    private val expirationSecond: Long,

    private val issuer: String,
) {
    fun createJwtToken(userSpecification: String): String {
        return Jwts.builder()
            .signWith(SecretKeySpec(secretKey.toByteArray(), io.jsonwebtoken.SignatureAlgorithm.HS512.jcaName))
            .subject(userSpecification)
            .issuer(issuer)
            .issuedAt(Timestamp.valueOf(now()))
            .expiration(Date.from(Instant.now().plus(expirationSecond, ChronoUnit.SECONDS)))
            .compact()
    }
}
