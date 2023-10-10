package yeo.chi.study.hexagonal.order.adapter.feign.food.data

import yeo.chi.study.hexagonal.order.domain.Food

data class FoodFeignResponse(
    val id: Long,

    val name: String,

    val price: Long,

    val introduce: String,

    val option: OptionResponse,
) {
    fun toDomain(): Food {
        return Food(
            id = id,
            name = name,
            price = price,
            introduce = introduce,
            option = option.toDomain(),
        )
    }
}
