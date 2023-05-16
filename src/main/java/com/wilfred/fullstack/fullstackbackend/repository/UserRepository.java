package com.wilfred.fullstack.fullstackbackend.repository;

import com.wilfred.fullstack.fullstackbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
