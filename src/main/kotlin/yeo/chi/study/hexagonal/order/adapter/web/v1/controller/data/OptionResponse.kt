package yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data

import yeo.chi.study.hexagonal.order.domain.Option

class OptionResponse(
    option: Option,
) {
    val name: String

    val price: Long

    init {
        name = option.name
        price = option.price
    }
}
