package com.shivam.users.socialmedia.model.posts;


import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class UserPosts {

  @Id
  private String id;
  private String userName;

  private ArrayList<Posts> userPosts;
  public UserPosts(String id, String userName,
      ArrayList<Posts> userPosts) {
    this.id = id;
    this.userName = userName;
    this.userPosts = userPosts;
  }

  public UserPosts(){

  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Posts> getUserPosts() {
    return userPosts;
  }

  public void setUserPosts(ArrayList<Posts> userPosts) {
    this.userPosts = userPosts;
  }
}
