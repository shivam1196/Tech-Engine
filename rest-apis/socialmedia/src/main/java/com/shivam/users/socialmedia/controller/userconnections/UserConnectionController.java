package com.shivam.users.socialmedia.controller.userconnections;

import com.shivam.users.socialmedia.model.connection.Connection;
import com.shivam.users.socialmedia.model.connection.requestmodel.AcceptConnectionRequest;
import com.shivam.users.socialmedia.model.connection.requestmodel.GetConnectionRequest;
import com.shivam.users.socialmedia.model.connection.requestmodel.SetConnectionRequest;
import com.shivam.users.socialmedia.model.registeruser.User;
import com.shivam.users.socialmedia.model.registeruser.requestmodel.UserProfileRequest;
import com.shivam.users.socialmedia.service.userconnections.UsersConnectionConnectionServiceLayerImp;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiResponses(value = {
    @ApiResponse(code = 400,message = "Bad Request send by server"),
    @ApiResponse(code = 401,message = "Unauthorised Request"),
    @ApiResponse(code = 500,message = "Server is Down")
})
public class UserConnectionController {
  @Autowired
  private UsersConnectionConnectionServiceLayerImp usersConnectionServiceLayerImp;

  @PostMapping(value = "/registerUser",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> registerUser(@RequestBody User user){
    usersConnectionServiceLayerImp.registerUser(user);
    return new ResponseEntity<String>("User Registered", HttpStatus.OK);
  }

  @GetMapping("/getAllUsers")
  public ResponseEntity<List<User>> getAllUsers(){
    return new ResponseEntity<List<User>>(usersConnectionServiceLayerImp.findAllUser(),HttpStatus.OK);
  }

  @PostMapping(value = "/getProfile", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Optional<User>> getUserProfile(@RequestBody UserProfileRequest userProfileRequest){
    Optional<User> userProfile = usersConnectionServiceLayerImp.findUserbyUserName(userProfileRequest.getRequestedUserName());
    return new ResponseEntity<>(userProfile,HttpStatus.OK);
  }

  @PostMapping(value = "/makeConnectionRequest",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> makeConnectionRequest(@RequestBody SetConnectionRequest setConnectionRequest){
    usersConnectionServiceLayerImp.addConnectionRequest(setConnectionRequest);
    return new ResponseEntity<>("Connection Send", HttpStatus.OK);
  }

  @PostMapping(value = "/getAllConnectionRequest",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Optional<Connection>> getAllConnectionRequest(@RequestBody GetConnectionRequest getConnectionRequest){
    Optional<Connection> connection = usersConnectionServiceLayerImp.getConnectionRequest(getConnectionRequest.getUserName());
    return new ResponseEntity<>(connection,HttpStatus.OK);
  }

  @GetMapping("/getAllConnections")
  public ResponseEntity<List<Connection>> getAllConnections(){
    List<Connection> allConnections = usersConnectionServiceLayerImp.findAllConnections();
    return new ResponseEntity<>(allConnections,HttpStatus.OK);
  }
  @PostMapping(value = "/acceptConnection", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> acceptConnectionRequest(@RequestBody AcceptConnectionRequest acceptConnectionRequest){
    usersConnectionServiceLayerImp.acceptConnection(acceptConnectionRequest);
    return new ResponseEntity<>("Connection Added",HttpStatus.OK);
  }

}
