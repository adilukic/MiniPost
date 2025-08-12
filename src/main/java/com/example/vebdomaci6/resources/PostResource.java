package com.example.vebdomaci6.resources;

import com.example.vebdomaci6.entities.Comment;
import com.example.vebdomaci6.entities.Post;
import com.example.vebdomaci6.services.PostService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/posts")
public class PostResource {
    @Inject
    private PostService postService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {
        return Response.ok(this.postService.allPosts()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Post create(@Valid Post post) {
        return this.postService.addPost(post);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post find(@PathParam("id") Integer id) {
        return this.postService.findPost(id);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        this.postService.deletePost(id);
    }

    @GET
    @Path("/{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllComments(@PathParam("id") int postId) {
        return postService.getAllComments(postId);
    }
    @POST
    @Path("/{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment addComment(@PathParam("id") int postId, @Valid Comment comment) {

        System.err.println("BBB");
        return this.postService.addComment(postId, comment);
    }

}
