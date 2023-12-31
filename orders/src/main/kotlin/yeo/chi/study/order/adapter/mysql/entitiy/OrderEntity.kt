package yeo.chi.study.order.adapter.mysql.entitiy

import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY
import yeo.chi.study.order.domain.vo.SearchedOrder
import java.time.LocalDateTime
import java.time.LocalDateTime.now

@Entity
@Table(name = "`order`")
class OrderEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long = 0,

    val restaurantId: Long,

    @ElementCollection
    @CollectionTable(
        name = "food_id",
        joinColumns = [JoinColumn(name = "order_id", referencedColumnName = "id")],
    )
    val foodIds: List<Long>,

    @ElementCollection
    @CollectionTable(
        name = "coupon_id",
        joinColumns = [JoinColumn(name = "order_id", referencedColumnName = "id")],
    )
    val couponIds: List<Long>,

    val createdAt: LocalDateTime = now(),

    var completeAt: LocalDateTime?,
) {
    fun toSearchedOrder(): SearchedOrder {
        return SearchedOrder(
            id = id,
            restaurantId = restaurantId,
            foodIds = foodIds,
            couponIds = couponIds,
            createdAt = createdAt,
            completeAt = completeAt,
        )
    }
}
