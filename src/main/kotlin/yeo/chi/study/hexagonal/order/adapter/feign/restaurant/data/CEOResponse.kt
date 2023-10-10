package yeo.chi.study.hexagonal.order.adapter.feign.restaurant.data

import yeo.chi.study.hexagonal.order.domain.CEO

data class CEOResponse(
    val id: Long,

    val name: String,

    val address: String,

    val registrationNumber: String,
) {
    fun toDomain(): CEO {
        return CEO(
            id = id,
            name = name,
            address = address,
            registrationNumber = registrationNumber,
        )
    }
}
