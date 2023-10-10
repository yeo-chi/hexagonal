package yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data

import yeo.chi.study.hexagonal.order.domain.Order
import java.time.LocalDateTime

class OrderResponse(
    order: Order,
) {
    val id: Long

    val restaurant: RestaurantResponse

    val foods: List<FoodResponse>

    val coupons: List<CouponResponse>

    val createdAt: LocalDateTime

    val completeAt: LocalDateTime?

    init {
        id = order.id
        restaurant = order.restaurant.let(::RestaurantResponse)
        foods = order.foods.map(::FoodResponse)
        coupons = order.coupons.map(::CouponResponse)
        createdAt = order.createdAt
        completeAt = order.completeAt
    }
}
