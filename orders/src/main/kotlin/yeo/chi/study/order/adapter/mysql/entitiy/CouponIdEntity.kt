package yeo.chi.study.order.adapter.mysql.entitiy

import jakarta.persistence.Embeddable
import jakarta.persistence.Table

@Embeddable
@Table(name = "coupon_id")
class CouponIdEntity(
    val couponId: Long,
)
