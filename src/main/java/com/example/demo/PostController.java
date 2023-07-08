package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
	private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public Iterable<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public void createPost(@RequestBody Post post) {
        postService.savePost(post);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post) {
        postService.updatePost(id, post.getTitle(), post.getContent());
    }

   }
