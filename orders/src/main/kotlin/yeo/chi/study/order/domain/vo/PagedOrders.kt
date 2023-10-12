package yeo.chi.study.order.domain.vo

import org.springframework.data.domain.Sort
import yeo.chi.study.order.domain.Order

class PagedOrders(
    val limit: Long,

    val offset: Long,

    val order: Sort.Direction,

    val totalCount: Long,

    val orders: List<Order> = listOf(),

    val searchedOrders: List<SearchedOrder> = listOf(),
)
