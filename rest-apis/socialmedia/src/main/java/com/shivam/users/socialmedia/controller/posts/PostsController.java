package com.shivam.users.socialmedia.controller.posts;


import com.shivam.users.socialmedia.model.posts.Posts;
import com.shivam.users.socialmedia.model.posts.UserPosts;
import com.shivam.users.socialmedia.service.posts.PostServiceLayerImp;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {
  @Autowired
  private PostServiceLayerImp postServiceLayerImp;


  @PostMapping(value = "/addPost",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> addPost(@RequestBody Posts posts){
    System.out.println("Add user post:"+posts.getPostMessage());
    postServiceLayerImp.addPost(posts);
    return new ResponseEntity<String>("Post Added", HttpStatus.OK);
  }

  @PostMapping(value = "/getPost",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Optional<UserPosts>> getUserPosts(@RequestBody Posts posts){
    String userName = posts.getUserName();
    Optional<UserPosts> userPosts = postServiceLayerImp.getUser(userName);
    return new ResponseEntity<Optional<UserPosts>>(userPosts,HttpStatus.OK);
  }
}
