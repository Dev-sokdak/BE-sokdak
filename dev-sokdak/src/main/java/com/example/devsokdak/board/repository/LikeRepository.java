package com.example.devsokdak.board.repository;

import com.example.devsokdak.board.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
