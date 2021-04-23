package miu.edu.lab3.service;

import miu.edu.lab3.domain.Post;
import miu.edu.lab3.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements  PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post getPost(int id) {
        return postRepository.getPost(id);
    }

    @Override
    public void savePost(Post post) {
        postRepository.savePost(post);
    }

    @Override
    public boolean deletePost(int id) {
        return postRepository.deletePost(id);
    }
}
