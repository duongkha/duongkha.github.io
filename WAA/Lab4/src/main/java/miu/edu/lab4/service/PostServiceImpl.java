package miu.edu.lab4.service;

import miu.edu.lab4.domain.Post;
import miu.edu.lab4.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements  PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getPost(int id) {
        try{
            return postRepository.getPostById(id);
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public boolean deletePost(int id) {
        return postRepository.deletePostById(id) > 0;
    }
}
