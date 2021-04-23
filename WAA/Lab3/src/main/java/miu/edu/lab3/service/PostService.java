package miu.edu.lab3.service;

import miu.edu.lab3.domain.Post;

import java.util.List;

public interface PostService {
    public List<Post> getAll();
    public Post getPost(int id);
    public void savePost(Post post);
    public boolean deletePost(int id);
}
