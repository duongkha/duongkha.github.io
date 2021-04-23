package miu.edu.lab3.controller;

import miu.edu.lab3.domain.Post;
import miu.edu.lab3.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> getAllPost(){
        return postService.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Post getPost(@PathVariable(value = "id") int id){
        return postService.getPost(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void savePost(@RequestBody Post post){
        postService.savePost(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deletePost(@PathVariable(value = "id") int id){
        return postService.deletePost(id);
    }
}
