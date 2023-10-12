package yeo.chi.study.order.adapter.web.v1.controller.data

import yeo.chi.study.order.domain.Restaurant

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
