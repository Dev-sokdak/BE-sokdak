package com.example.sokdak.board.repository;


import com.example.sokdak.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository  extends JpaRepository<Board, Long> {

    List<Board> findAllByOrderByCreatedAtDesc();

    List<Board> findAllByCategoryOrderByCreatedAtDesc(int interestTag);
    Optional<Board> findByIdAndNickname(Long id, String nickname);

}
