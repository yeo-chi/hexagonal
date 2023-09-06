package yeo.chi.study.hexagonal.order.adapter.web.v1.controller

import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data.OrderCreateRequest
import yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data.OrderSearchRequest
import yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data.OrderResponse
import yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data.OrderResponses

@RestController
@RequestMapping("api/v1/order")
class OrderController {

    @GetMapping
    @ResponseStatus(OK)
    fun getOrders(searchRequest: OrderSearchRequest): OrderResponses{

    }

    @GetMapping("{id}")
    @ResponseStatus(OK)
    fun getOrder(): OrderResponse {

    }

    @PostMapping
    @ResponseStatus(CREATED)
    fun createOrder(@RequestBody createRequest: OrderCreateRequest) {

    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    fun deleteOrder(@PathParam("id") id: Long) {

    }
}
