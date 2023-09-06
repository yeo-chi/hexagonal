package yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data

import yeo.chi.study.hexagonal.order.domain.vo.SearchCondition

data class OrderSearchRequest(
    val order: Order,

    val limit: Long,

    val offset: Long,
) {
    fun toSearchCondition(): SearchCondition {
        return SearchCondition(
            order = order,
            limit = limit,
            offset = offset,
        )
    }
}
