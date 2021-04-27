package miu.edu.lab4.service;

import miu.edu.lab4.domain.Post;

import java.util.List;

public interface PostService {
    public List<Post> getAll();
    public Post getPost(int id);
    public void savePost(Post post);
    public boolean deletePost(int id);
}
