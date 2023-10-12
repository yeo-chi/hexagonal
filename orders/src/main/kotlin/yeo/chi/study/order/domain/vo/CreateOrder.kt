package yeo.chi.study.order.domain.vo

import java.time.LocalDateTime
import java.time.LocalDateTime.now

class CreateOrder(
    val restaurantId: Long,

    val foodIds: List<Long>,

    val couponIds: List<Long>,

    val createdAt: LocalDateTime = now(),
)
