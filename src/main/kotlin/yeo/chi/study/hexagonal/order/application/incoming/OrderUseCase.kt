package yeo.chi.study.hexagonal.order.application.incoming

import yeo.chi.study.hexagonal.order.domain.Order
import yeo.chi.study.hexagonal.order.domain.vo.CreateOrder
import yeo.chi.study.hexagonal.order.domain.vo.PagedOrders
import yeo.chi.study.hexagonal.order.domain.vo.SearchCondition

interface OrderUseCase {
    fun getList(searchCondition: SearchCondition): PagedOrders

    fun getOne(id: Long): Order

    fun create(createOrder: CreateOrder): Order

    fun delete(id: Long)
}
