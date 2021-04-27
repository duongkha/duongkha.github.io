package miu.edu.lab4.controller;

import miu.edu.lab4.domain.Post;
import miu.edu.lab4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping(value="")
    public List<Post> getAllPost(){
        return postService.getAll();
    }

    //@RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public Post getPost(@PathVariable(value = "id") int id){
        return postService.getPost(id);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping(value = "")
    public void savePost(@RequestBody Post post){
        postService.savePost(post);
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/{id}")
    public boolean deletePost(@PathVariable(value = "id") int id){
        return postService.deletePost(id);
    }
}
