package miu.edu.lab3.repository;

import miu.edu.lab3.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private List<Post> posts;
    public PostRepositoryImpl() {
        posts = new ArrayList<Post>();
        for(int i= 0; i < 5; i++){
            Post post = new Post(i + 1,"Post " + i, "Content " + i, "Author " + i);
            posts.add(post);
        }
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Post getPost(int id) {
        return posts.stream().filter(x->x.getId() == id).findFirst().get();
    }

    @Override
    public void savePost(Post post) {
        posts.add(post);
    }

    @Override
    public boolean deletePost(int id) {
        if(posts.stream().anyMatch(x->x.getId() == id)) {
            posts.remove(id);
            return true;
        }
        return false;
    }
}
