package yeo.chi.study.hexagonal.order.application.outgoing

import yeo.chi.study.hexagonal.order.domain.Restaurant

interface RestaurantPort {
    fun findOne(id: Long): Restaurant
}
