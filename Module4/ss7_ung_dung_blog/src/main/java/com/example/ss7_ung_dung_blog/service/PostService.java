package com.example.ss7_ung_dung_blog.service;

import com.example.ss7_ung_dung_blog.model.Post;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<Post> getAllPosts(int page, int size, String sortBy);
}
