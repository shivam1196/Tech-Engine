package com.shivam.users.socialmedia.controller.connection;


import com.shivam.users.socialmedia.model.connection.Connection;
import com.shivam.users.socialmedia.model.connection.requestmodel.AcceptConnectionRequest;
import com.shivam.users.socialmedia.model.connection.requestmodel.GetConnectionRequest;
import com.shivam.users.socialmedia.model.connection.requestmodel.SetConnectionRequest;
import com.shivam.users.socialmedia.service.connection.ConnectionServiceLayerImp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMongoRepositories
public class ConnectionController {
  @Autowired
  private ConnectionServiceLayerImp connectionServiceLayerImp;

  @PostMapping(value = "/makeConnectionRequest",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> makeConnectionRequest(@RequestBody SetConnectionRequest setConnectionRequest){
    connectionServiceLayerImp.addConnectionRequest(setConnectionRequest);
    return new ResponseEntity<>("Connection Send", HttpStatus.OK);
  }

  @PostMapping(value = "/getAllConnectionRequest",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Optional<Connection>> getAllConnectionRequest(@RequestBody GetConnectionRequest getConnectionRequest){
    Optional<Connection> connection = connectionServiceLayerImp.getConnectionRequest(getConnectionRequest.getUserName());
    return new ResponseEntity<>(connection,HttpStatus.OK);
  }

  @GetMapping("/getAllConnections")
  public ResponseEntity<List<Connection>> getAllConnections(){
    List<Connection> allConnections = connectionServiceLayerImp.findAllConnections();
    return new ResponseEntity<>(allConnections,HttpStatus.OK);
  }
  @PostMapping(value = "/acceptConnection", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> acceptConnectionRequest(@RequestBody AcceptConnectionRequest acceptConnectionRequest){
    connectionServiceLayerImp.acceptConnection(acceptConnectionRequest);
    return new ResponseEntity<>("Connection Added",HttpStatus.OK);
  }

}
