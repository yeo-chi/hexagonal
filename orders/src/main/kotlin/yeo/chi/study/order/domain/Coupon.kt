package yeo.chi.study.order.domain

import java.math.BigDecimal

class Coupon(
    val id: Long,

    val name: String,

    val trigger: Trigger,

    val discountPrice: Long?,

    val discountPercent: BigDecimal?,
) {
    fun discount(price: Long): Long {
        if (isTrigger(price = price)) {
            return discountPrice?.run {
                price - this
            } ?: discountPercent?.run {
                price - (this.multiply(price.toBigDecimal())).toLong()
            } ?: price
        }

        return price
    }

    private fun isTrigger(price: Long): Boolean = trigger.pass(price = price)
}
