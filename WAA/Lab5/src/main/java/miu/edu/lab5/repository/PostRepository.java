package miu.edu.lab5.repository;

import miu.edu.lab5.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
    List<Post> findAll();
    Post getPostById(long id);
    Post save(Post post);
    int deletePostById(long id);
}
