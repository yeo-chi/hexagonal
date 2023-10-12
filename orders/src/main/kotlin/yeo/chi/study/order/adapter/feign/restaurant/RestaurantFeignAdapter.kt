package yeo.chi.study.order.adapter.feign.restaurant

import org.springframework.stereotype.Repository
import yeo.chi.study.order.application.outgoing.RestaurantPort
import yeo.chi.study.order.domain.Restaurant

@Repository
class RestaurantFeignAdapter(
    private val restaurantFeignClient: RestaurantFeignClient,
) : RestaurantPort {
    override fun findOne(id: Long): Restaurant {
        return restaurantFeignClient.findById(id = id).toDomain()
    }
}
