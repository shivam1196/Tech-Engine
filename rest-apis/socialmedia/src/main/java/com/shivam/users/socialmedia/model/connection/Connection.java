package com.shivam.users.socialmedia.model.connection;


import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "connections")
public class Connection {

  @Id
  private String id;
  private String userName;
  private List<String> connectionIds;
  private List<String> addedConnectionsUserName;




  public Connection(String id, String userName,
      List<String> connectionIds, List<String> addedConnectionsUserName) {
    this.id = id;
    this.userName = userName;

    this.connectionIds = connectionIds;
    this.addedConnectionsUserName = addedConnectionsUserName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public List<String> getAddedConnectionsUserName() {
    return addedConnectionsUserName;
  }

  public void setAddedConnectionsUserName(List<String> addedConnectionsUserName) {
    this.addedConnectionsUserName = addedConnectionsUserName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public List<String> getConnectionIds() {
    return connectionIds;
  }

  public void setConnectionIds(List<String> connectionIds) {
    this.connectionIds = connectionIds;
  }

  public Connection(){

  }

  @Override
  public String toString() {
    return "Connection{" +
        "id='" + id + '\'' +
        ", userName='" + userName + '\'' +
        ", connectionIds=" + connectionIds +
        ", addedConnectionsUserName=" + addedConnectionsUserName +
        '}';
  }
}
