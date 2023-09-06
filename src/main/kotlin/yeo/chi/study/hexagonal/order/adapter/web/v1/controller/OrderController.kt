package yeo.chi.study.hexagonal.order.adapter.web.v1.controller

import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/order")
class OrderController {

    @GetMapping
    fun getOrders(searchRequest: OrderSearchRequest) {

    }

    @GetMapping("{id}")
    fun getOrder() {

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
