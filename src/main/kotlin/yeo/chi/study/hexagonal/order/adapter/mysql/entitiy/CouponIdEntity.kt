package yeo.chi.study.hexagonal.order.adapter.mysql.entitiy

import jakarta.persistence.Embeddable

@Embeddable
class CouponIdEntity(
    val couponId: Long,
)
