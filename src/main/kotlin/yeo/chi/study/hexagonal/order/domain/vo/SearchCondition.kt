package yeo.chi.study.hexagonal.order.domain.vo

import yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data.Order

class SearchCondition(
    val order: Order,

    val limit: Long,

    val offset: Long,
)
