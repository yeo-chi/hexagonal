package yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data

import yeo.chi.study.hexagonal.order.domain.vo.PagedOrders

class OrderResponses(
    pagedOrders: PagedOrders,
) {
    val order: Order

    val limit: Long

    val offset: Long

    val total: Long

    val orders: List<OrderResponse>

    init {
        order = Order.of(pagedOrders.order)
        limit = pagedOrders.limit
        offset = pagedOrders.offset
        total = pagedOrders.totalCount
        orders = pagedOrders.orders.map(::OrderResponse)
    }
}
