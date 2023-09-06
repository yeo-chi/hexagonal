package yeo.chi.study.hexagonal.order.adapter.web.v1.controller.data

data class OrderSearchRequest(
    val order: Order,

    val limit: Long,

    val offset: Long,
) {
    fun toSearchCondition() {

    }
}
