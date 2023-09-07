package yeo.chi.study.hexagonal.order.adapter.mysql

import org.springframework.data.domain.Page
import org.springframework.stereotype.Repository
import yeo.chi.study.hexagonal.order.application.outgoing.OrderJpaRepository
import yeo.chi.study.hexagonal.order.domain.Order
import yeo.chi.study.hexagonal.order.domain.vo.CreateOrder
import yeo.chi.study.hexagonal.order.domain.vo.SearchCondition

@Repository
class OrderJpaRepositoryAdapter(
    private val orderRepository: OrderRepository,
) : OrderJpaRepository {
    override fun findAll(searchCondition: SearchCondition): Page<Order> {
        val orderEntities = orderRepository.findAll(searchCondition.pageable)
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
