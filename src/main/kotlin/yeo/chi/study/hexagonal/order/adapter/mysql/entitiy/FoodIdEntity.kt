package yeo.chi.study.hexagonal.order.adapter.mysql.entitiy

import jakarta.persistence.Embeddable
import jakarta.persistence.Table

@Embeddable
@Table(name = "food_id")
class FoodIdEntity(
    val foodId: Long,
)
