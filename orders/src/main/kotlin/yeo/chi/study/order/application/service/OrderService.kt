package yeo.chi.study.order.application.service

import org.springframework.stereotype.Service
import yeo.chi.study.order.application.incoming.OrderUseCase
import yeo.chi.study.order.application.outgoing.CouponPort
import yeo.chi.study.order.application.outgoing.FoodPort
import yeo.chi.study.order.application.outgoing.OrderPort
import yeo.chi.study.order.application.outgoing.RestaurantPort
import yeo.chi.study.order.domain.Order
import yeo.chi.study.order.domain.vo.CreateOrder
import yeo.chi.study.order.domain.vo.PagedOrders
import yeo.chi.study.order.domain.vo.SearchCondition

@Service
class OrderService(
    private val orderPort: OrderPort,
    private val restaurantPort: RestaurantPort,
    private val foodPort: FoodPort,
    private val couponPort: CouponPort,
) : OrderUseCase {
    override fun getList(searchCondition: SearchCondition): PagedOrders {
        return orderPort.findAll(searchCondition = searchCondition)
    }

    override fun getOne(id: Long): Order {
        return orderPort.findOne(id = id).let {
            Order(
                id = it.id,
                restaurant = restaurantPort.findOne(id = it.restaurantId),
                foods = it.foodIds.map { foodId ->
                    foodPort.findOne(id = foodId)
                },
                coupons = it.couponIds.map { couponId ->
                    couponPort.findOne(id = couponId)
                },
                createdAt = it.createdAt,
                completeAt = it.completeAt,
            )
        }
    }

    override fun create(createOrder: CreateOrder): Order {
        return orderPort.insert(createOrder = createOrder).let {
            Order(
                id = it.id,
                restaurant = restaurantPort.findOne(id = it.restaurantId),
                foods = it.foodIds.map { foodId ->
                    foodPort.findOne(id = foodId)
                },
                coupons = it.couponIds.map { couponId ->
                    couponPort.findOne(id = couponId)
                },
                createdAt = it.createdAt,
                completeAt = it.completeAt,
            )
        }
    }

    override fun delete(id: Long) {
        orderPort.delete(id = id)
    }
}
