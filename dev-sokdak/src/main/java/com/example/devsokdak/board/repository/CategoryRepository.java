package com.example.devsokdak.board.repository;

import com.example.devsokdak.board.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByInterestTag(int interestTag);
}
