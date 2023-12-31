package yeo.chi.study.user.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import yeo.chi.study.user.controller.data.SignInRequest
import yeo.chi.study.user.controller.data.SignUpRequest
import yeo.chi.study.user.persistant.entity.UserEntity
import yeo.chi.study.user.persistant.repotiry.UserRepository

@Service
class UsersService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    @Transactional(readOnly = true)
    fun validUser(signInRequest: SignInRequest) {
        userRepository.findByUserId(userId = signInRequest.userId)?.also {
            check(passwordEncoder.matches(signInRequest.password, it.password))
        } ?: throw NoSuchElementException()
    }

    @Transactional
    fun createUser(signUpRequest: SignUpRequest) {
        userRepository.findByUserId(userId = signUpRequest.userId) ?: apply {
            UserEntity.create(signUpRequest = signUpRequest, encoder = passwordEncoder).also {
                userRepository.save(it)
            }

            return
        }

        throw IllegalArgumentException()
    }
}
