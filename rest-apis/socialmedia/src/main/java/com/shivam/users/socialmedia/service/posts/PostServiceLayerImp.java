package com.shivam.users.socialmedia.service.posts;

import com.shivam.users.socialmedia.model.posts.Posts;
import com.shivam.users.socialmedia.model.posts.UserPosts;
import com.shivam.users.socialmedia.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceLayerImp implements PostServiceLayer {
  @Autowired
  private PostRepository postRepository;
  @Override
  public void addPost(Posts addPosts) {
    postRepository.save(addUserPosts(addPosts));
  }

  @Override
  public Optional<UserPosts> getUser(String userName) {
    return postRepository.findPostByUserName(userName);
  }

  private UserPosts addUserPosts(Posts addPosts){
    Optional<UserPosts> posts = postRepository.findPostByUserName(addPosts.getUserName());
    if(!posts.isPresent()) {
      UserPosts userPosts = new UserPosts();
      String userName = addPosts.getUserName();
      System.out.println("Post Message: " + addPosts.getPostMessage());
      userPosts.setUserName(userName);
      ArrayList<Posts> userPost = new ArrayList<>();
      userPost.add(addPosts);
      userPosts.setUserPosts(userPost);
      return userPosts;
    }else{
      ArrayList<Posts> postsArrayList = posts.get().getUserPosts();
      postsArrayList.add(addPosts);
      posts.get().setUserPosts(postsArrayList);
      return posts.get();
    }

  }
}
