package yeo.chi.study.user.configuration.jwt

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime.now
import java.time.temporal.ChronoUnit
import java.util.*
import javax.crypto.spec.SecretKeySpec

@Service
class TokenProvider(
    private val jwtConfiguration: JwtConfiguration,
) {
    fun createJwtToken(userSpecification: String): String {
        return Jwts.builder()
            .signWith(
                SecretKeySpec(
                    jwtConfiguration.secretKey.toByteArray(),
                    io.jsonwebtoken.SignatureAlgorithm.HS512.jcaName
                )
            )
            .subject(userSpecification)
            .issuer(jwtConfiguration.issuer)
            .issuedAt(Timestamp.valueOf(now()))
            .expiration(Date.from(Instant.now().plus(jwtConfiguration.expirationSecond, ChronoUnit.SECONDS)))
            .compact()
    }

    fun validateTokenAndGetSubject(token: String): String? {
        return Jwts.parser()
            .verifyWith(
                SecretKeySpec(
                    jwtConfiguration.secretKey.toByteArray(),
                    io.jsonwebtoken.SignatureAlgorithm.HS512.jcaName,
                )
            )
            .build()
            .parseSignedClaims(token)
            .payload
            .subject
    }
}
