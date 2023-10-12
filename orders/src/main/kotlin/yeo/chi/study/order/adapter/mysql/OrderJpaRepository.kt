package yeo.chi.study.order.adapter.mysql

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import yeo.chi.study.order.adapter.mysql.entitiy.OrderEntity

@Repository
interface OrderJpaRepository : JpaRepository<OrderEntity, Long>
