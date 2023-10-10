package yeo.chi.study.hexagonal.order.application.outgoing

import yeo.chi.study.hexagonal.order.domain.Food

interface FoodPort {
    fun findOne(id: Long): Food
}
