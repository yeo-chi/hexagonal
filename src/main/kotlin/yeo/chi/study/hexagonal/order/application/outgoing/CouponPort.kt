package yeo.chi.study.hexagonal.order.application.outgoing

import yeo.chi.study.hexagonal.order.domain.Coupon

interface CouponPort {
    fun findOne(id: Long): Coupon
}
