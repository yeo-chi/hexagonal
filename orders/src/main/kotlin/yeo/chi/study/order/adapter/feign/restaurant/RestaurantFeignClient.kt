package yeo.chi.study.order.adapter.feign.restaurant

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import yeo.chi.study.order.adapter.feign.restaurant.data.RestaurantFeignResponse

@FeignClient(name = "RESTAURANT", url = "\${external-api.restaurant}")
interface RestaurantFeignClient {
    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: Long): RestaurantFeignResponse
}
