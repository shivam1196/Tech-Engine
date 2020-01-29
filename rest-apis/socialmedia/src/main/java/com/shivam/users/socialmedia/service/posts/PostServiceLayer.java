package com.shivam.users.socialmedia.service.posts;

import com.shivam.users.socialmedia.model.posts.Posts;
import com.shivam.users.socialmedia.model.posts.UserPosts;
import java.util.Optional;

public interface PostServiceLayer {
  void addPost(Posts addPosts);

  Optional<UserPosts> getUser(String userName);

  Optional<UserPosts> addComment(Posts addCommentToPost);

}
