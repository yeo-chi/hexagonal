package yeo.chi.study.order.adapter.web.v1.controller.data

import yeo.chi.study.order.domain.Food

class FoodResponse(
    food: Food,
) {
    val id: Long

    val name: String

    val price: Long

    val option: OptionResponse

    init {
        id = food.id
        name = food.name
        price = food.price + food.option.price
        option = food.option.let(::OptionResponse)
    }
}
