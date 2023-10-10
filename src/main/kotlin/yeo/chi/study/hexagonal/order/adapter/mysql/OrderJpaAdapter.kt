package yeo.chi.study.hexagonal.order.adapter.mysql

import org.springframework.stereotype.Repository
import yeo.chi.study.hexagonal.order.application.outgoing.OrderPort
import yeo.chi.study.hexagonal.order.domain.Order
import yeo.chi.study.hexagonal.order.domain.vo.CreateOrder
import yeo.chi.study.hexagonal.order.domain.vo.PagedOrders
import yeo.chi.study.hexagonal.order.domain.vo.SearchCondition

@Repository
class OrderJpaAdapter(
    private val orderJpaRepository: OrderJpaRepository,
) : OrderPort {
    override fun findAll(searchCondition: SearchCondition): PagedOrders {
        return orderJpaRepository.findAll(searchCondition.pageable).let { orderEntities ->
            PagedOrders(
                limit = orderEntities.pageable.pageSize.toLong(),
                offset = orderEntities.pageable.offset,
                order = searchCondition.order.direction,
                totalCount = orderEntities.totalElements,
                searchedOrders = orderEntities.content.map {
                    it.toSearchedOrder()
                },
            )
        }
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
