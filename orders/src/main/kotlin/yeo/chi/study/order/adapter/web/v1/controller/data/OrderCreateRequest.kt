package yeo.chi.study.order.adapter.web.v1.controller.data

import yeo.chi.study.order.domain.vo.CreateOrder

data class OrderCreateRequest(
    val restaurantId: Long,

    val foodIds: List<Long>,

    val couponIds: List<Long>,
) {
    fun toCreateOrder(): CreateOrder {
        return CreateOrder(
            restaurantId = restaurantId,
            foodIds = foodIds,
            couponIds = couponIds,
        )
    }
}
