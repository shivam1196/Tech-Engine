package com.shivam.users.socialmedia.model.connection.requestmodel;

public class GetConnectionRequest {
  private String userName;

  public GetConnectionRequest(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public GetConnectionRequest() {
  }
}

