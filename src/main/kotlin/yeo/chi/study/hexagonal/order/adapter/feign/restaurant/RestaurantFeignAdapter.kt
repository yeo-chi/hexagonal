package yeo.chi.study.hexagonal.order.adapter.feign.restaurant

import org.springframework.stereotype.Repository
import yeo.chi.study.hexagonal.order.application.outgoing.RestaurantPort
import yeo.chi.study.hexagonal.order.domain.Restaurant

@Repository
class RestaurantFeignAdapter(
    private val restaurantFeignClient: RestaurantFeignClient,
) : RestaurantPort {
    override fun findOne(id: Long): Restaurant {
        return restaurantFeignClient.findById(id = id).toDomain()
    }
}
