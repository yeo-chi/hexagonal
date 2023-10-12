package yeo.chi.study.order.application.outgoing

import yeo.chi.study.order.domain.Food

interface FoodPort {
    fun findOne(id: Long): Food
}
