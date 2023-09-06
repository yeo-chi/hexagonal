package yeo.chi.study.hexagonal.order.adapter.mysql

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import yeo.chi.study.hexagonal.order.adapter.mysql.entitiy.OrderEntity

@Repository
interface OrderRepository : JpaRepository<OrderEntity, Long>
