package yeo.chi.study.hexagonal.order.domain.vo

import java.time.LocalDateTime

class SearchedOrder(
    val id: Long,

    val restaurantId: Long,

    val foodIds: List<Long>,

    val couponIds: List<Long>,

    val createdAt: LocalDateTime,

    val completeAt: LocalDateTime?,
)
