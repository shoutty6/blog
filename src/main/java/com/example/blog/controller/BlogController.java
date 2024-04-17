package com.example.blog.controller;

import com.example.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    private final List<Post> posts = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", posts);
        return "index";
    }

    @PostMapping("/addPost")
    public String addPost(@RequestParam String title, @RequestParam String content) {
        posts.add(new Post(title, content));
        return "redirect:/";
    }

    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable("id") long id) {
        posts.removeIf(p -> p.getId() == id);
        return "redirect:/";
    }
}
