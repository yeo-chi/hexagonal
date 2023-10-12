package yeo.chi.study.hexagonal.order.application.outgoing

import yeo.chi.study.hexagonal.order.domain.Order
import yeo.chi.study.hexagonal.order.domain.vo.CreateOrder
import yeo.chi.study.hexagonal.order.domain.vo.PagedOrders
import yeo.chi.study.hexagonal.order.domain.vo.SearchCondition
import yeo.chi.study.hexagonal.order.domain.vo.SearchedOrder

interface OrderPort {
    fun findAll(searchCondition: SearchCondition): PagedOrders

    fun findOne(id: Long): SearchedOrder

    fun insert(createOrder: CreateOrder): SearchedOrder

    fun delete(id: Long)
}
