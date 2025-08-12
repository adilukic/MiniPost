package com.example.vebdomaci6.services;

import com.example.vebdomaci6.entities.Comment;
import com.example.vebdomaci6.entities.Post;
import com.example.vebdomaci6.repositories.post.PostRepo;

import javax.inject.Inject;
import java.util.List;

public class PostService {
    public PostService() {
        System.out.println(this);
    }
    @Inject
    private PostRepo postRepository;

    public Post addPost(Post post) {
        return this.postRepository.addPost(post);
    }

    public List<Post> allPosts() {
        return this.postRepository.allPosts();
    }

    public Post findPost(Integer id) {
        return this.postRepository.findPost(id);
    }

    public void deletePost(Integer id) {
        this.postRepository.deletePost(id);
    }
    public List<Comment> getAllComments(Integer postId){
        return this.postRepository.getAllComments(postId);
    }
    public Comment addComment(Integer postId, Comment comment){
        return this.postRepository.addComent(postId, comment);
    }

}
