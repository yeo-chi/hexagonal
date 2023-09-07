package yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data

import org.springframework.data.domain.Sort

enum class Order(val direction: Sort.Direction) {
    ASC(Sort.Direction.ASC),
    DESC(Sort.Direction.DESC),
}
