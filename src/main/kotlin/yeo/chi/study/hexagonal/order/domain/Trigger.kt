package yeo.chi.study.hexagonal.order.domain

class Trigger(
    val id: Long,

    val price: Long,
) {
    fun pass(price: Long): Boolean = isBiggerOrEquals(price = price)

    private fun isBiggerOrEquals(price: Long): Boolean = this.price <= price
}
