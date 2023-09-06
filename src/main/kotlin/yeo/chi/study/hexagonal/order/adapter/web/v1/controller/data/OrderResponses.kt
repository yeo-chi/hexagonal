package yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data

data class OrderResponses(
    val order: Order,

    val limit: Long,

    val offset: Long,

    val orders: List<OrderResponse>,
)
