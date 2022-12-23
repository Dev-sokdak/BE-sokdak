package com.example.devsokdak.comment.repository;

import com.example.devsokdak.comment.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
