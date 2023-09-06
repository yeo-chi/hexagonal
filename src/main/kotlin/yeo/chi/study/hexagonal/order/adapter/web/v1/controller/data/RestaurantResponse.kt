package yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data

import yeo.chi.study.hexagonal.order.domain.Restaurant

class RestaurantResponse(
    restaurant: Restaurant,
) {
    val id: Long

    val name: String

    init {
        id = restaurant.id
        name = restaurant.name
    }
}
