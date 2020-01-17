package com.shivam.users.socialmedia.model.registeruser.requestmodel;

public class UserProfileRequest {
  private String currentUserName;
  private String requestedUserName;

  public UserProfileRequest(String currentUserName, String requestedUserName) {
    this.currentUserName = currentUserName;
    this.requestedUserName = requestedUserName;
  }

  public UserProfileRequest(){

  }

  public String getCurrentUserName() {
    return currentUserName;
  }

  public void setCurrentUserName(String currentUserName) {
    this.currentUserName = currentUserName;
  }

  public String getRequestedUserName() {
    return requestedUserName;
  }

  public void setRequestedUserName(String requestedUserName) {
    this.requestedUserName = requestedUserName;
  }
}
