package com.example.ss7_ung_dung_blog.repository;

import com.example.ss7_ung_dung_blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
