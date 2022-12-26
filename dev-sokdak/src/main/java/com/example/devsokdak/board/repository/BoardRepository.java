package com.example.devsokdak.board.repository;

import com.example.devsokdak.board.entity.Board;
import com.example.devsokdak.board.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository  extends JpaRepository<Board, Long> {

    List<Board> findAllByOrderByCreatedAtDesc();

    Board findByCategory(int intersetTag);
    Optional<Board> findByIdAndNickname(Long id, String nickname);

}
