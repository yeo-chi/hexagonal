package yeo.chi.study.order.domain.vo

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import yeo.chi.study.order.adapter.web.v1.controller.data.Order

class SearchCondition(
    val order: Order,

    limit: Long,

    offset: Long,
) {
    val pageable: Pageable = PageRequest.of(
        offset.toInt(), limit.toInt(), order.direction
    )
}
