package yeo.chi.study.order.domain

import java.time.LocalDateTime
import java.time.LocalDateTime.now

class Order(
    val id: Long,

    val restaurant: Restaurant,

    val foods: List<Food>,

    val coupons: List<Coupon>,

    val createdAt: LocalDateTime,

    var completeAt: LocalDateTime?
) {
    private val order: OrderNumber = OrderNumber()

    val number = order.number

    fun complete() {
        completeAt = now()
    }
}
