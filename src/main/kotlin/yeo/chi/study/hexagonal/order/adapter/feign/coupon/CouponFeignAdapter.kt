package yeo.chi.study.hexagonal.order.adapter.feign.coupon

import org.springframework.stereotype.Repository
import yeo.chi.study.hexagonal.order.application.outgoing.CouponPort
import yeo.chi.study.hexagonal.order.domain.Coupon

@Repository
class CouponFeignAdapter(
    private val couponFeignClient: CouponFeignClient,
) : CouponPort {
    override fun findOne(id: Long): Coupon {
        return couponFeignClient.findOne(id = id).toDomain()
    }
}
