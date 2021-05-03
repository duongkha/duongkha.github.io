package miu.edu.lab5.repository;

import miu.edu.lab5.domain.Post;
import miu.edu.lab5.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findAll();
    User getUserById(long id);
    User save(User post);
    int deleteUserById(long id);
    @Query(value="Select u From User u Where u.posts.size > 1")
    List<User> getUsersHaveMultiplePosts();
}
