package yeo.chi.study.order.adapter.feign.food

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import yeo.chi.study.order.adapter.feign.food.data.FoodFeignResponse


@FeignClient(name = "FOOD", url = "\${external-api.food}")
interface FoodFeignClient {
    @GetMapping("{id}")
    fun findOne(@PathVariable("id") id: Long): FoodFeignResponse
}
