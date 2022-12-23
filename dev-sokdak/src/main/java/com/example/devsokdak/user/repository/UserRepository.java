package com.example.devsokdak.user.repository;

import com.example.devsokdak.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
