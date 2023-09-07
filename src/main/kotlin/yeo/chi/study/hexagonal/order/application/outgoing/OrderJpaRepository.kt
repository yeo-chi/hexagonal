package yeo.chi.study.hexagonal.order.application.outgoing

import org.springframework.data.domain.Page
import yeo.chi.study.hexagonal.order.domain.Order
import yeo.chi.study.hexagonal.order.domain.vo.CreateOrder
import yeo.chi.study.hexagonal.order.domain.vo.SearchCondition

interface OrderJpaRepository {
    fun findAll(searchCondition: SearchCondition): Page<Order>

    fun findOne(id: Long): Order

    fun insert(createOrder: CreateOrder)

    fun delete(id: Long)
}
