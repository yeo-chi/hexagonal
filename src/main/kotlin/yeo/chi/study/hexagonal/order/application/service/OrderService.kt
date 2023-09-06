package yeo.chi.study.hexagonal.order.application.service

import org.springframework.stereotype.Service
import yeo.chi.study.hexagonal.order.application.incoming.OrderUseCase
import yeo.chi.study.hexagonal.order.domain.Order
import yeo.chi.study.hexagonal.order.domain.vo.CreateOrder
import yeo.chi.study.hexagonal.order.domain.vo.SearchCondition

@Service
class OrderService(

) : OrderUseCase {
    override fun getList(searchCondition: SearchCondition): List<Order> {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): Order {
        TODO("Not yet implemented")
    }

    override fun create(createOrder: CreateOrder): Order {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}
