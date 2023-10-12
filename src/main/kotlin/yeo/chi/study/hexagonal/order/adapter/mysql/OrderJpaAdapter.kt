package yeo.chi.study.hexagonal.order.adapter.mysql

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import yeo.chi.study.hexagonal.order.adapter.mysql.entitiy.OrderEntity
import yeo.chi.study.hexagonal.order.application.outgoing.OrderPort
import yeo.chi.study.hexagonal.order.domain.Order
import yeo.chi.study.hexagonal.order.domain.vo.CreateOrder
import yeo.chi.study.hexagonal.order.domain.vo.PagedOrders
import yeo.chi.study.hexagonal.order.domain.vo.SearchCondition
import yeo.chi.study.hexagonal.order.domain.vo.SearchedOrder

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

    override fun findOne(id: Long): SearchedOrder {
        return orderJpaRepository.findByIdOrNull(id = id)?.toSearchedOrder() ?: throw NoSuchElementException()
    }

    override fun insert(createOrder: CreateOrder): SearchedOrder {
        return orderJpaRepository.save(
            OrderEntity(
                restaurantId = createOrder.restaurantId,
                foodIds = createOrder.foodIds,
                couponIds = createOrder.couponIds,
                completeAt = null,
            )
        ).toSearchedOrder()
    }

    override fun delete(id: Long) {
        return orderJpaRepository.deleteById(id)
    }
}
