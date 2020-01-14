package com.shivam.users.socialmedia.model.connection.requestmodel;

public class SetConnectionRequest {
  private String requestedUserName;
  private String senderUserName;

  public SetConnectionRequest(String requestedUserName,
      String senderUserName) {
    this.requestedUserName = requestedUserName;
    this.senderUserName = senderUserName;
  }

  public SetConnectionRequest() {
  }

  public String getRequestedUserName() {
    return requestedUserName;
  }

  public void setRequestedUserName(String requestedUserName) {
    this.requestedUserName = requestedUserName;
  }



  public String getSenderUserName() {
    return senderUserName;
  }

  public void setSenderUserName(String senderUserName) {
    this.senderUserName = senderUserName;
  }
}
