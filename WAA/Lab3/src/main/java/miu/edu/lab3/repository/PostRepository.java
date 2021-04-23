package miu.edu.lab3.repository;

import miu.edu.lab3.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PostRepository {
    public List<Post> getAll();
    public Post getPost(int id);
    public void savePost(Post post);
    public boolean deletePost(int id);
}
