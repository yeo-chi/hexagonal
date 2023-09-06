package yeo.chi.study.hexagonal.order.adapter.mysql

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import yeo.chi.study.hexagonal.order.application.outgoing.OrderJpaRepository
import yeo.chi.study.hexagonal.order.domain.Order
import yeo.chi.study.hexagonal.order.domain.vo.CreateOrder

@Repository
class OrderJpaRepositoryAdapter(
    private val orderRepository: OrderRepository,
) : OrderJpaRepository {
    override fun findAll(pageable: Pageable): List<Order> {
        TODO("Not yet implemented")
    }

    override fun findOne(id: Long): Order {
        TODO("Not yet implemented")
    }

    override fun insert(createOrder: CreateOrder) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}
