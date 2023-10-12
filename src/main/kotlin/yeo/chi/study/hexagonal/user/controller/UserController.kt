package yeo.chi.study.hexagonal.user.controller

import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*
import yeo.chi.study.hexagonal.configuration.jwt.TokenProvider
import yeo.chi.study.hexagonal.user.controller.data.SignInRequest
import yeo.chi.study.hexagonal.user.controller.data.SignUpRequest
import yeo.chi.study.hexagonal.user.controller.data.SignUpResponse
import yeo.chi.study.hexagonal.user.service.UsersService

@RestController
@RequestMapping("api/v1/users")
class UserController(
    private val userService: UsersService,
    private val tokenProvider: TokenProvider,
) {
    @PostMapping("signIn")
    fun signIn(@RequestBody signInRequest: SignInRequest): String {
        userService.validUser(signInRequest = signInRequest)

        return tokenProvider.createJwtToken(userSpecification = signInRequest.userId)
    }

    @PostMapping
    @ResponseStatus(CREATED)
    fun signUp(@RequestBody signUpRequest: SignUpRequest): SignUpResponse {
        userService.createUser(signUpRequest = signUpRequest)

        return SignUpResponse(
            userId = signUpRequest.userId,
            token = tokenProvider.createJwtToken(userSpecification = signUpRequest.userId)
        )
    }
}
