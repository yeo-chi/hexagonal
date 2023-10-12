package yeo.chi.study.order.application.outgoing

import yeo.chi.study.order.domain.Restaurant

interface RestaurantPort {
    fun findOne(id: Long): Restaurant
}
