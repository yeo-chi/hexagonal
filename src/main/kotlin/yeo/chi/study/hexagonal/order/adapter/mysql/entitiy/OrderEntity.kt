package yeo.chi.study.hexagonal.order.adapter.mysql.entitiy

import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY
import java.time.LocalDateTime

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

    val createdAt: LocalDateTime,

    var completeAt: LocalDateTime?,
)
