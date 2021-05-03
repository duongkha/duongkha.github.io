package miu.edu.lab5.service;

import miu.edu.lab5.domain.User;
import miu.edu.lab5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        try{
            return userRepository.getUserById(id);
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.deleteUserById(id) > 0;
    }

    @Override
    public List<User> getUsersHaveMoreThanPost(){
        return userRepository.getUsersHaveMultiplePosts();
    }
}
