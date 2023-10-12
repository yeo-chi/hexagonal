package yeo.chi.study.order.adapter.feign.coupon

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import yeo.chi.study.order.adapter.feign.coupon.data.CouponFeignResponse

@FeignClient(name = "COUPON", url = "\${external-api.coupon}")
interface CouponFeignClient {
    @GetMapping("{id}")
    fun findOne(@PathVariable("id") id: Long): CouponFeignResponse
}
