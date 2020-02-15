package com.shivam.users.socialmedia.model.connection.requestmodel;

public class AcceptConnectionRequest {
  private String currentUserName;
  private String acceptedUserName;

  public AcceptConnectionRequest(String currentUserName, String acceptedUserName) {
    this.currentUserName = currentUserName;
    this.acceptedUserName = acceptedUserName;
  }

  public AcceptConnectionRequest() {
  }

  public String getCurrentUserName() {
    return currentUserName;
  }

  public void setCurrentUserName(String currentUserName) {
    this.currentUserName = currentUserName;
  }

  public String getAcceptedUserName() {
    return acceptedUserName;
  }

  public void setAcceptedUserName(String acceptedUserName) {
    this.acceptedUserName = acceptedUserName;
  }
}
