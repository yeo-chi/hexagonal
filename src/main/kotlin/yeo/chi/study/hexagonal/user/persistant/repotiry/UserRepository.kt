package yeo.chi.study.hexagonal.user.persistant.repotiry

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import yeo.chi.study.hexagonal.user.persistant.entity.UserEntity

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByUserId(userId: String): UserEntity?
}
