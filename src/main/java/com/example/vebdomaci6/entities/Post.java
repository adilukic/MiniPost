package com.example.vebdomaci6.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private Integer id;
    @NotNull(message = "Author field is required")
    @NotEmpty(message = "Author field is required")
    private String author;
    @NotNull(message = "Title field is required")
    @NotEmpty(message = "Title field is required")
    private String title;

    @NotNull(message = "Content field is required")
    @NotEmpty(message = "Content field is required")
    private String content;
    private List<Comment> comments = new ArrayList<>();

    public Post(String author, String title, String content) {
        this();
        this.author = author;
        this.title = title;
        this.content = content;
    }
    public Post(Integer id, String author, String title, String content) {
        this();
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }
    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
