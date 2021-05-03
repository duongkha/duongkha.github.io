package miu.edu.lab5.service;

import miu.edu.lab5.domain.Post;
import miu.edu.lab5.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User getUser(int id);
    public void saveUser(User user);
    public boolean deleteUser(int id);
    List<User> getUsersHaveMoreThanPost();
}
