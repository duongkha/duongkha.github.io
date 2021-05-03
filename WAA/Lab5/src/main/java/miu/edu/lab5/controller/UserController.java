package miu.edu.lab5.controller;

import miu.edu.lab5.domain.Post;
import miu.edu.lab5.domain.User;
import miu.edu.lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value="")
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable(value = "id") int id){
        return userService.getUser(id);
    }

    @PostMapping(value = "")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping(value = "/{id}/posts")
    public List<Post> getPostsByUser(@PathVariable(value = "id") int id){
        return userService.getUser(id).getPosts();
    }
    @GetMapping(value = "/userbypost")
    public List<User> getUserByPost(){
        return userService.getUsersHaveMoreThanPost();
    }
}
