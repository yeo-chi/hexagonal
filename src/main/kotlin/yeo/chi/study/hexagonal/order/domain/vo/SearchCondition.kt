package yeo.chi.study.hexagonal.order.domain.vo

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data.Order

class SearchCondition(
    order: Order,

    limit: Long,

    offset: Long,
) {
    val pageable: Pageable

    init {
        pageable = PageRequest.of(
            offset.toInt(), limit.toInt(), order.direction
        )
    }
}
