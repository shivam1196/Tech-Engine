package com.shivam.users.socialmedia.model.connection.requestmodel;

public class GetConnectionRequest {
  private String connectionId;

  public GetConnectionRequest(String connectionId) {
    this.connectionId = connectionId;
  }

  public String getConnectionId() {
    return connectionId;
  }

  public void setConnectionId(String connectionId) {
    this.connectionId = connectionId;
  }

  public GetConnectionRequest() {
  }
}

