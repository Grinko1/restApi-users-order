package com.example.repository;

import com.example.model.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ShopOrder, Long> {
}
