package yeo.chi.study.order.application.outgoing

import yeo.chi.study.order.domain.Coupon

interface CouponPort {
    fun findOne(id: Long): Coupon
}
