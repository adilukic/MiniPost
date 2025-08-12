package com.example.vebdomaci6.repositories.post;

import com.example.vebdomaci6.entities.Comment;
import com.example.vebdomaci6.entities.Post;

import java.util.List;

public interface PostRepo {
    public Post addPost(Post post);
    public void deletePost(Integer id);
    public List<Post> allPosts();
    public Post findPost(Integer id);
    public Comment addComent(Integer postId, Comment comment);
    public List<Comment> getAllComments(Integer postId);
    public void deleteComment(Comment comment);

}
