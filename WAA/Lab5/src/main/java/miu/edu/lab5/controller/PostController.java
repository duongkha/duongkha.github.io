package miu.edu.lab5.controller;

import miu.edu.lab5.domain.Post;
import miu.edu.lab5.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(value="")
    public List<Post> getAllPost(){
        return postService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Post getPost(@PathVariable(value = "id") int id){
        return postService.getPost(id);
    }

    @PostMapping(value = "")
    public void savePost(@RequestBody Post post){
        postService.savePost(post);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deletePost(@PathVariable(value = "id") int id){
        return postService.deletePost(id);
    }
}
