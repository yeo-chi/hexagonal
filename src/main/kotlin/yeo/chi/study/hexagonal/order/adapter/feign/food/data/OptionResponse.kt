package yeo.chi.study.hexagonal.order.adapter.feign.food.data

import yeo.chi.study.hexagonal.order.domain.Option

data class OptionResponse(
    val id: Long,

    val name: String,

    val price: Long,
) {
    fun toDomain(): Option {
        return Option(
            id = id,
            name = name,
            price = price,
        )
    }
}
