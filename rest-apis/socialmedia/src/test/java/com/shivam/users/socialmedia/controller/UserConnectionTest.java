package com.shivam.users.socialmedia.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.shivam.users.socialmedia.TestUtils;
import com.shivam.users.socialmedia.controller.userconnections.UserConnectionController;
import com.shivam.users.socialmedia.model.connection.requestmodel.AcceptConnectionRequest;
import com.shivam.users.socialmedia.model.connection.requestmodel.SetConnectionRequest;
import com.shivam.users.socialmedia.model.registeruser.User;
import com.shivam.users.socialmedia.model.registeruser.requestmodel.UserProfileRequest;
import com.shivam.users.socialmedia.service.userconnections.UsersConnectionConnectionServiceLayerImp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserConnectionTest {

  private UsersConnectionConnectionServiceLayerImp connectionConnectionServiceLayerImp = mock(UsersConnectionConnectionServiceLayerImp.class);

  private BCryptPasswordEncoder passwordEncoder = mock(BCryptPasswordEncoder.class);

  private UserConnectionController userConnectionController;

  @Before
  public void setUp(){
    userConnectionController = new UserConnectionController();
    TestUtils.injectObjects(userConnectionController,"usersConnectionServiceLayerImp",connectionConnectionServiceLayerImp);
    TestUtils.injectObjects(userConnectionController,"bCryptPasswordEncoder",passwordEncoder);
  }

  @Test
  public void createUserTest(){
    User user = getTestUser();
    final ResponseEntity<User> userResponseEntity = userConnectionController.registerUser(user);
    assertNotNull(userResponseEntity);
    assertNotNull(userResponseEntity.getBody());
    assertEquals("Shivam",userResponseEntity.getBody().getFirstName());
    assertEquals("Srivastav",userResponseEntity.getBody().getLastName());
    assertEquals("thisIsHashed",userResponseEntity.getBody().getPassword());
    assertEquals("srivastavs",userResponseEntity.getBody().getUserName());

  }

  @Test
  public void getAllUser(){
    User user = getTestUser();
    List<User > userListBody = new ArrayList<>();
    userListBody.add(user);
    when(connectionConnectionServiceLayerImp.findAllUser()).thenReturn(userListBody);
    ResponseEntity<List<User>> userList =userConnectionController.getAllUsers();
    assertNotNull(userList.getBody());
    assertEquals(200,userList.getStatusCode().value());
    assertEquals(1,userList.getBody().size());

    userListBody.add(getTestUser());
    userListBody.add(getTestUser());

    userList = userConnectionController.getAllUsers();

    assertNotNull(userList.getBody());
    assertEquals(200,userList.getStatusCode().value());
    assertEquals(3,userList.getBody().size());


  }

  @Test
  public void getUserProfile(){
      User user=getTestUser();
      UserProfileRequest userProfileRequest=new UserProfileRequest();
      userProfileRequest.setRequestedUserName(user.getUserName());
      when(connectionConnectionServiceLayerImp.findUserbyUserName(user.getUserName())).thenReturn(
          Optional.of(user));
      ResponseEntity<Optional<User>> userProfile = userConnectionController.getUserProfile(userProfileRequest);
      assertNotNull(userProfile.getBody());
      assertEquals(200,userProfile.getStatusCode().value());
      assertEquals(userProfile.getBody().get().getUserName(),user.getUserName());

  }

  @Test
  public void makeConnectionRequest(){
    SetConnectionRequest setConnectionRequest = new SetConnectionRequest();
    setConnectionRequest.setSenderUserName("ashia");
    setConnectionRequest.setRequestedUserName("srivastavs");
    ResponseEntity<String > connectionRequest = userConnectionController.makeConnectionRequest(setConnectionRequest);

    assertNotNull(connectionRequest);
    assertNotNull(connectionRequest.getBody());
    assertEquals("Connection Send",connectionRequest.getBody());
  }

  @Test
  public void acceptConnectionRequest(){
    AcceptConnectionRequest acceptConnectionRequest = new AcceptConnectionRequest();
    acceptConnectionRequest.setCurrentUserName("srivastavs");
    acceptConnectionRequest.setAcceptedUserName("ashia");
    ResponseEntity<String> acceptedConnection = userConnectionController.acceptConnectionRequest(acceptConnectionRequest);

    assertNotNull(acceptedConnection.getBody());
    assertEquals(200,acceptedConnection.getStatusCode().value());
    assertEquals("Connection Added",acceptedConnection.getBody());

  }

  private User getTestUser(){
    when(passwordEncoder.encode("testPassword")).thenReturn("thisIsHashed");
    User user = new User();

    user.setFirstName("Shivam");
    user.setLastName("Srivastav");
    user.setUserName("srivastavs");
    user.setPassword("testPassword");
    user.setAge(23);
    user.setGender("Male");
    return user;
  }
}
