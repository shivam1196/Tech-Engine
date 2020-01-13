package com.shivam.users.socialmedia.model.connection.requestmodel;

public class SetConnectionRequest {
  private String userId;
  private String firstName;
  private String lastName;
  private String connectionId;

  public SetConnectionRequest(String userId, String firstName, String lastName,
      String connectionId) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.connectionId = connectionId;
  }

  public SetConnectionRequest() {
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getConnectionId() {
    return connectionId;
  }

  public void setConnectionId(String connectionId) {
    this.connectionId = connectionId;
  }
}
