package yeo.chi.study.order.application.incoming

import yeo.chi.study.order.domain.Order
import yeo.chi.study.order.domain.vo.CreateOrder
import yeo.chi.study.order.domain.vo.PagedOrders
import yeo.chi.study.order.domain.vo.SearchCondition

interface OrderUseCase {
    fun getList(searchCondition: SearchCondition): PagedOrders

    fun getOne(id: Long): Order

    fun create(createOrder: CreateOrder): Order

    fun delete(id: Long)
}
