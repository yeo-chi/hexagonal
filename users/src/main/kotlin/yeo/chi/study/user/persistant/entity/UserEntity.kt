package yeo.chi.study.user.persistant.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.security.crypto.password.PasswordEncoder
import yeo.chi.study.user.controller.data.SignUpRequest
import java.time.LocalDateTime
import java.time.LocalDateTime.now

@Table(name = "`user`")
@Entity
class UserEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long = 0,

    val userId: String,

    val password: String,

    val createdAt: LocalDateTime = now(),

    val updatedAt: LocalDateTime? = null,

    val deletedAt: LocalDateTime? = null,
) {
    companion object {
        fun create(signUpRequest: SignUpRequest, encoder: PasswordEncoder): UserEntity {
            return UserEntity(
                userId = signUpRequest.userId,
                password = encoder.encode(signUpRequest.password),
            )
        }
    }
}
