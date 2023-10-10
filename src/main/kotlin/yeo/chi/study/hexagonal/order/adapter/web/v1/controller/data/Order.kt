package yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data

import org.springframework.data.domain.Sort.Direction

enum class Order(val direction: Direction) {
    ASC(Direction.ASC),
    DESC(Direction.DESC),
    ;

    companion object {
        fun of(direction: Direction): Order {
            return when (direction) {
                Direction.ASC -> ASC
                Direction.DESC -> DESC
            }
        }
    }
}
