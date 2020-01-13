package com.shivam.users.socialmedia.service.connection;

import com.shivam.users.socialmedia.model.connection.Connection;
import com.shivam.users.socialmedia.model.connection.requestmodel.SetConnectionRequest;
import com.shivam.users.socialmedia.repository.ConnectionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionServiceLayerImp implements ConnectionServiceLayer {
  @Autowired
  private ConnectionRepository connectionRepository;

  @Override
  public void addConnectionRequest(SetConnectionRequest setConnectionRequest) {
      connectionRepository.save(setUpConnection(setConnectionRequest));


  }

  private Connection setUpConnection(SetConnectionRequest setConnectionRequest){
    Connection connection = new Connection();
    connection.setId(setConnectionRequest.getUserId());
    connection.setFirstName(setConnectionRequest.getFirstName());
    connection.setLastName(setConnectionRequest.getLastName());
    List<String> connectionIds = new ArrayList<>();
    connectionIds.add(setConnectionRequest.getConnectionId());
    connection.setConnectionIds(connectionIds);
    return connection;
  }

  @Override
  public Optional<Connection> getConnectionRequest(String userId) {
    System.out.println("Connection Id: "+ connectionRepository.findById(userId).toString());
     return connectionRepository.findById(userId);
  }
}
