package yeo.chi.study.order.adapter.web.v1.controller.data

import yeo.chi.study.order.domain.Coupon
import java.math.BigDecimal

class CouponResponse(
    coupon: Coupon
) {
    val id: Long

    val discountPrice: Long?

    val discountPercent: BigDecimal?

    init {
        id = coupon.id
        discountPrice = coupon.discountPrice
        discountPercent = coupon.discountPercent
    }
}
