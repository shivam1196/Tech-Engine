package com.shivam.users.socialmedia.model.registeruser;


import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

  @Id
  private String id;

  private String firstName;

  private String lastName;

  private String gender;



  private String userName;

  private int age;

  private List<String> areaOfInterest;

  public List<String> getAreaOfInterest() {
    return areaOfInterest;
  }

  public void setAreaOfInterest(List<String> areaOfInterest) {
    this.areaOfInterest = areaOfInterest;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public User(String id, String firstName, String lastName, String gender, String userName, int age,
      List<String> areaOfInterest) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.userName = userName;
    this.age = age;
    this.areaOfInterest = areaOfInterest;
  }
  public User(){

  }

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", gender='" + gender + '\'' +
        ", age=" + age +
        '}';
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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
