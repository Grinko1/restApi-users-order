package com.example.repository;

import com.example.model.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ShopUser, Long> {
}
