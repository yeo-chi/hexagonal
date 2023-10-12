package yeo.chi.study.order.adapter.web.v1.controller

import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import yeo.chi.study.order.adapter.web.v1.controller.data.OrderCreateRequest
import yeo.chi.study.order.adapter.web.v1.controller.data.OrderResponse
import yeo.chi.study.order.adapter.web.v1.controller.data.OrderResponses
import yeo.chi.study.order.adapter.web.v1.controller.data.OrderSearchRequest
import yeo.chi.study.order.application.incoming.OrderUseCase

@RestController
@RequestMapping("api/v1/order")
class OrderController(
    private val orderUseCase: OrderUseCase,
) {
    @GetMapping
    @ResponseStatus(OK)
    fun getOrders(searchRequest: OrderSearchRequest): OrderResponses {
        return orderUseCase.getList(searchCondition = searchRequest.toSearchCondition()).let(::OrderResponses)
    }

    @GetMapping("{id}")
    @ResponseStatus(OK)
    fun getOrder(@PathVariable("id") id: Long): OrderResponse {
        return orderUseCase.getOne(id = id).let(::OrderResponse)
    }

    @PostMapping
    @ResponseStatus(CREATED)
    fun createOrder(@RequestBody createRequest: OrderCreateRequest) {
        orderUseCase.create(createOrder = createRequest.toCreateOrder())
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    fun deleteOrder(@PathParam("id") id: Long) {
        orderUseCase.delete(id = id)
    }
}
