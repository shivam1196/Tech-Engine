package com.shivam.users.socialmedia.repository;

import com.shivam.users.socialmedia.model.posts.Posts;
import com.shivam.users.socialmedia.model.posts.UserPosts;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends MongoRepository<UserPosts,String> {
  Optional<UserPosts> findPostByUserName(String userName);
}
