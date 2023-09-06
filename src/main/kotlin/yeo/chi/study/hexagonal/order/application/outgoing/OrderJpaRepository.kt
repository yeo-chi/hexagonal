package yeo.chi.study.hexagonal.order.application.outgoing

import org.springframework.data.domain.Pageable
import yeo.chi.study.hexagonal.order.domain.Order
import yeo.chi.study.hexagonal.order.domain.vo.CreateOrder

interface OrderJpaRepository {
    fun findAll(pageable: Pageable): List<Order>

    fun findOne(id: Long): Order

    fun insert(createOrder: CreateOrder)

    fun delete(id: Long)
}
