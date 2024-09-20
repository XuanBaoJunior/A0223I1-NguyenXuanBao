package com.example.ss7_ung_dung_blog.controller;

import com.example.ss7_ung_dung_blog.model.Category;
import com.example.ss7_ung_dung_blog.model.Post;
import com.example.ss7_ung_dung_blog.service.CategoryService;
import com.example.ss7_ung_dung_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

//    @Autowired
//    private CategoryService categoryService;
//
//    @Autowired
//    private PostService postService;
//
//    @GetMapping("/")
//    public String getAllPosts(Model model) {
//        List<Post> posts = postService.getAllPosts();
//        model.addAttribute("posts", posts);
//        return "posts";
//    }
//
//    @GetMapping("/categories")
//    public String getAllCategories(Model model) {
//        List<Category> categories = categoryService.getAllCategories();
//        model.addAttribute("categories", categories);
//        model.addAttribute("category", new Category()); // For create form
//        return "categories";
//    }
//
//    @PostMapping("/categories/save")
//    public String saveCategory(@ModelAttribute("category") Category category) {
//        if (category.getId() == null) {
//            categoryService.saveCategory(category);
//        } else {
//            categoryService.updateCategory(category);
//        }
//        return "redirect:/blog/categories";
//    }
//
//    @GetMapping("/categories/edit/{id}")
//    public String showEditCategoryForm(@PathVariable("id") Long id, Model model) {
//        Category category = categoryService.getCategoryById(id);
//        model.addAttribute("category", category);
//        return "categories";
//    }
//
//    @GetMapping("/categories/delete/{id}")
//    public String deleteCategory(@PathVariable("id") Long id) {
//        categoryService.deleteCategory(id);
//        return "redirect:/blog/categories";
//    }
//
//    @GetMapping("/posts/create")
//    public String showCreatePostForm(Model model) {
//        model.addAttribute("post", new Post());
//        return "post-form";
//    }
//
//    @PostMapping("/posts/save")
//    public String savePost(@ModelAttribute("post") Post post) {
//        if (post.getId() == null) {
//            postService.savePost(post);
//        } else {
//            postService.updatePost(post);
//        }
//        return "redirect:/blog/";
//    }
//
//    @GetMapping("/posts/edit/{id}")
//    public String showEditPostForm(@PathVariable("id") Long id, Model model) {
//        Post post = postService.getPostById(id);
//        model.addAttribute("post", post);
//        return "post-form";
//    }
//
//    @GetMapping("/posts/delete/{id}")
//    public String deletePost(@PathVariable("id") Long id) {
//        postService.deletePost(id);
//        return "redirect:/blog/";
//    }
}
