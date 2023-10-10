package yeo.chi.study.hexagonal.order.adapter.feign.food

import org.springframework.stereotype.Repository
import yeo.chi.study.hexagonal.order.application.outgoing.FoodPort
import yeo.chi.study.hexagonal.order.domain.Food

@Repository
class FoodFeignAdapter(
    private val foodFeignClient: FoodFeignClient,
) : FoodPort {
    override fun findOne(id: Long): Food {
        return foodFeignClient.findOne(id = id).toDomain()
    }
}
