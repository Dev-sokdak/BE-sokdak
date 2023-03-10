package com.example.sokdak.user.repository;


import com.example.sokdak.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);

    boolean findAllByUserId(String userId);

    boolean existsByUserId(String UserId);
}
