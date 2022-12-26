package com.example.sokdak.board.repository;


import com.example.sokdak.board.entity.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<BoardLike, Long> {
    Optional<BoardLike> findByBoardIdAndUserId(Long boardId , Long UserId);

    void deleteByBoardIdAndUserId(Long boardId, Long userId);

    @Query(value = "select count(1) from board_like inner join boards on board_like.board_id = boards.id where board_like.board_id = :boardId", nativeQuery = true)
    Long likeCnt(@PathVariable("id") Long boardId);
}