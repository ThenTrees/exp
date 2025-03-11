package com.thentrees.orderservice.repository;

import com.thentrees.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
