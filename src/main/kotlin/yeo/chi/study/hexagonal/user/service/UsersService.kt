package yeo.chi.study.hexagonal.user.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import yeo.chi.study.hexagonal.user.controller.data.SignInRequest
import yeo.chi.study.hexagonal.user.controller.data.SignUpRequest
import yeo.chi.study.hexagonal.user.persistant.entity.UserEntity
import yeo.chi.study.hexagonal.user.persistant.repotiry.UserRepository

@Service
class UsersService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    fun validUser(signInRequest: SignInRequest) {
        userRepository.findByUserId(userId = signInRequest.userId)?.also {
            check(passwordEncoder.matches(signInRequest.password, it.password))
        } ?: throw NoSuchElementException()
    }

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
