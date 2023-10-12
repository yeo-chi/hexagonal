package yeo.chi.study.order.adapter.feign.restaurant.data

import yeo.chi.study.order.domain.CloseDay
import yeo.chi.study.order.domain.Restaurant
import java.time.LocalDateTime

data class RestaurantFeignResponse(
    val id: Long,

    val name: String,

    val address: String,

    val openedAt: LocalDateTime,

    val closedAt: LocalDateTime,

    val closeDays: List<CloseDay>,

    val introduce: String,

    val ceo: CEOResponse,
) {
    fun toDomain(): Restaurant {
        return Restaurant(
            id = id,
            name = name,
            address = address,
            openedAt = openedAt,
            closedAt = closedAt,
            closeDays = closeDays,
            introduce = introduce,
            ceo = ceo.toDomain(),
        )
    }
}
