package com.shivam.users.socialmedia.model.posts;


import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Posts {


  private String userName;
  private String postMessage;
  private List<String> userComments;
  private List<String> userLikes;

  public Posts( String userName, String postMessage,
      List<String> userComments, List<String> userLikes) {
    this.userName = userName;
    this.postMessage = postMessage;
    this.userComments = userComments;
    this.userLikes = userLikes;
  }

  public Posts(){

  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPostMessage() {
    return postMessage;
  }

  public void setPostMessage(String postMessage) {
    this.postMessage = postMessage;
  }

  public List<String> getUserComments() {
    return userComments;
  }

  public void setUserComments(List<String> userComments) {
    this.userComments = userComments;
  }

  public List<String> getUserLikes() {
    return userLikes;
  }

  public void setUserLikes(List<String> userLikes) {
    this.userLikes = userLikes;
  }
}
