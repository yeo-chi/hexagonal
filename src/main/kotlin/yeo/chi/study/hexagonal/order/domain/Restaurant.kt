package yeo.chi.study.hexagonal.order.domain

import java.time.LocalDateTime

class Restaurant(
    val id: Long,

    val name: String,

    val address: String,

    val openedAt: LocalDateTime,

    val closedAt: LocalDateTime,

    val closeDays: List<CloseDay>,

    val introduce: String,

    val ceo: CEO,
)
