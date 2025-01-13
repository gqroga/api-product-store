package com.productstore.repositories;

import com.productstore.entities.OrderItem;
import com.productstore.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
