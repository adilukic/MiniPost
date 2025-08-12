package com.example.vebdomaci6.repositories.post;

import com.example.vebdomaci6.entities.Comment;
import com.example.vebdomaci6.entities.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPostRepo extends MySqlAbstractRepo implements PostRepo {
    @Override
    public Post addPost(Post post) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement("INSERT INTO posts (author, title, content) VALUES(?, ?, ?)", generatedColumns);
            preparedStatement.setString(1, post.getAuthor());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setString(3, post.getTitle());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                post.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return post;
    }

    @Override
    public void deletePost(Integer id) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = this.newConnection();
            stmt = connection.prepareStatement("DELETE FROM posts WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(stmt);
            this.closeConnection(connection);
        }
    }

    @Override
    public List<Post> allPosts() {
        List<Post> posts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = this.newConnection();
            stmt = connection.prepareStatement("SELECT * FROM posts");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Post post = new Post(
                        rs.getInt("id"),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getString("content")
                );
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(rs);
            this.closeStatement(stmt);
            this.closeConnection(connection);
        }

        return posts;
    }


    @Override
    public Post findPost(Integer id) {
        Post post = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = this.newConnection();
            stmt = connection.prepareStatement("SELECT * FROM posts WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                post =  new Post(
                        rs.getInt("id"),
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getString("content")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(rs);
            this.closeStatement(stmt);
            this.closeConnection(connection);
        }

        return post;
    }

    @Override
    public Comment addComent(Integer postId, Comment comment) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = this.newConnection();

            String[] generated = {"id"};
            stmt = connection.prepareStatement(
                    "INSERT INTO comments (post_id, author, content) VALUES (?, ?, ?)", generated
            );

            stmt.setInt(1, postId);
            stmt.setString(2, comment.getName());
            stmt.setString(3, comment.getContent());
            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                comment.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(rs);
            this.closeStatement(stmt);
            this.closeConnection(connection);
        }

        return comment;
    }

    @Override
    public List<Comment> getAllComments(Integer postId) {
        List<Comment> comments = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = this.newConnection();
            stmt = connection.prepareStatement("SELECT * FROM comments WHERE post_id = ?");
            stmt.setInt(1, postId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Comment comment = new Comment(
                        rs.getInt("id"),
                        rs.getString("author"),
                        rs.getString("content")
                );
                comments.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(rs);
            this.closeStatement(stmt);
            this.closeConnection(connection);
        }

        return comments;
    }

    @Override
    public void deleteComment(Comment comment) {

    }
}
