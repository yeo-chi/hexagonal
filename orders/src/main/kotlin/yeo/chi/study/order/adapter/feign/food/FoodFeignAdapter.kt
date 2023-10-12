package yeo.chi.study.order.adapter.feign.food

import org.springframework.stereotype.Repository
import yeo.chi.study.order.application.outgoing.FoodPort
import yeo.chi.study.order.domain.Food

@Repository
class FoodFeignAdapter(
    private val foodFeignClient: FoodFeignClient,
) : FoodPort {
    override fun findOne(id: Long): Food {
        return foodFeignClient.findOne(id = id).toDomain()
    }
}
