package yeo.chi.study.order.adapter.feign.coupon.data

import yeo.chi.study.order.domain.Coupon
import yeo.chi.study.order.domain.Trigger
import java.math.BigDecimal

data class CouponFeignResponse(
    val id: Long,

    val name: String,

    val trigger: Trigger,

    val discountPrice: Long?,

    val discountPercent: BigDecimal?,
) {
    fun toDomain(): Coupon {
        return Coupon(
            id = id,
            name = name,
            trigger = trigger,
            discountPrice = discountPrice,
            discountPercent = discountPercent,
        )
    }
}
