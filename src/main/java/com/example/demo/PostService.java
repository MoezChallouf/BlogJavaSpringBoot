package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;

public class PostService {
	
	@Autowired
	 private  PostRepository postRepository;

	    public PostService(PostRepository postRepository) {
	        this.postRepository = postRepository;
	    }

	    public Post getPostById(Long id) {
	        return postRepository.findById(id).orElse(null);
	    }
	    public Iterable<Post> getAllPosts() {
	        return postRepository.findAll();
	    }

	    public void savePost(Post post) {
	        postRepository.save(post);
	    }
	    public void updatePost(Long id, String title, String content) {
	        Post post = postRepository.findById(id).orElse(null);
	        if (post != null) {
	            post.setTitle(title);
	            post.setContent(content);
	            postRepository.save(post);
	        }
	    }
	    public void deletePost(Long id) {
	        postRepository.deleteById(id);

}}
	    