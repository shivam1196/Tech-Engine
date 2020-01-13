package com.shivam.users.socialmedia.model.connection;


import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "connections")
public class Connection {

  @Id
  private String id;

  private String firstName;
  private String lastName;
  private List<String> connectionIds;
  private List<String> addedConnections;


  public Connection(String id, String firstName, String lastName,
      List<String> connectionIds, List<String> addedConnections) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.connectionIds = connectionIds;
    this.addedConnections = addedConnections;
  }

  public List<String> getAddedConnections() {
    return addedConnections;
  }

  public void setAddedConnections(List<String> addedConnections) {
    this.addedConnections = addedConnections;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", connectionIds=" + connectionIds +
        '}';
  }
}
