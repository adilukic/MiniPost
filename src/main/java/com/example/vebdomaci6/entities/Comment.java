package com.example.vebdomaci6.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Comment {
    private Integer id;
    @NotNull(message = "Name field is required")
    @NotEmpty(message = "Name field is required")
    private String name;
    @NotNull(message = "Comment content field is required")
    @NotEmpty(message = "Comment content field is required")
    private String content;


    public Comment(String name, String content) {
        this();
        this.name = name;
        this.content = content;
    }
    public Comment(Integer id, String name, String content) {
        this();
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
