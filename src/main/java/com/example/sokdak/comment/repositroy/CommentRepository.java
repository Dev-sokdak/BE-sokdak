package com.example.sokdak.comment.repositroy;


import com.example.sokdak.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findById(Long id);
    Optional<Comment> findByIdAndUserId(Long id, String userId);
    List<Comment> findAllByBoardId(Long id);
    Long countByBoardId(Long id);
}
