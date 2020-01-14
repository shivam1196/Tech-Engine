package com.shivam.users.socialmedia.controller.user;

import com.shivam.users.socialmedia.model.registeruser.User;
import com.shivam.users.socialmedia.service.user.UsersServiceLayerImp;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
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
public class UserController {
  @Autowired
  private UsersServiceLayerImp usersServiceLayerImp;

  @PostMapping(value = "/registerUser",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> registerUser(@RequestBody User user){
    usersServiceLayerImp.registerUser(user);
    return new ResponseEntity<String>("User Registered", HttpStatus.OK);
  }

  @GetMapping("/getAllUsers")
  public ResponseEntity<List<User>> getAllUsers(){
    return new ResponseEntity<List<User>>(usersServiceLayerImp.findAllUser(),HttpStatus.OK);
  }

}
