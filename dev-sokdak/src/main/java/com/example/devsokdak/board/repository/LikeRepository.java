package com.example.devsokdak.board.repository;

import com.example.devsokdak.board.entity.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<BoardLike, Long> {
    Optional<BoardLike> findByBoardIdAndUserId(Long boardId , Long UserId);

    void deleteByBoardIdAndUserId(Long boardId, Long userId);
}
