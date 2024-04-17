package com.example.blog.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private static long count = 0;
    private final long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Post(String title, String content) {
        this.id = ++count; // Простой способ генерации уникальных ID
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now(); // Устанавливаем текущее время как время создания
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        return createdAt.format(formatter); // Форматируем дату в читаемый вид
    }
}
