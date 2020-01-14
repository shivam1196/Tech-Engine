package com.shivam.users.socialmedia.service.connection;

import com.shivam.users.socialmedia.model.connection.Connection;
import com.shivam.users.socialmedia.model.connection.requestmodel.AcceptConnectionRequest;
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
    Optional<Connection> checkConnection = connectionRepository.findConnectionByUserName(setConnectionRequest.getRequestedUserName());
    if(!checkConnection.isPresent()) {
      connectionRepository.save(setUpConnection(setConnectionRequest));
    }else{
        connectionRepository.save(addConnection(setConnectionRequest,checkConnection.get()));
    }


  }

  private Connection setUpConnection(SetConnectionRequest setConnectionRequest){
    Connection connection = new Connection();
    connection.setUserName(setConnectionRequest.getRequestedUserName());
    List<String> connectionIds = new ArrayList<>();
    connectionIds.add(setConnectionRequest.getSenderUserName());
    connection.setConnectionIds(connectionIds);
    return connection;

  }

  private Connection addConnection(SetConnectionRequest setConnectionRequest, Connection connection){
    List<String> connectionsId = connection.getConnectionIds();
    if(connectionsId == null){
      connectionsId = new ArrayList<>();
    }
    connectionsId.add(setConnectionRequest.getSenderUserName());
    connection.setConnectionIds(connectionsId);
    return connection;
  }


  @Override
  public Optional<Connection> getConnectionRequest(String userName) {
    System.out.println("Connection Id: "+userName);
    System.out.println("Connection Id: "+ connectionRepository.findConnectionByUserName(userName).toString());
     return connectionRepository.findConnectionByUserName(userName);
  }

  @Override
  public List<Connection> findAllConnections() {
    return connectionRepository.findAll();
  }

  @Override
  public void acceptConnection(AcceptConnectionRequest acceptConnectionRequest) {
      acceptUserConnection(acceptConnectionRequest);
      acceptSenderConnection(acceptConnectionRequest);


  }

  private void acceptUserConnection(AcceptConnectionRequest acceptConnectionRequest){
    Connection connection = connectionRepository.findConnectionByUserName(acceptConnectionRequest.getCurrentUserName()).get();
    List<String> pendingConnection = connection.getConnectionIds();
    List<String> addedConnection = connection.getAddedConnectionsUserName();
    if(addedConnection == null){
      addedConnection = new ArrayList<>();
      addedConnection.add(acceptConnectionRequest.getAcceptedUserName());
    }else{
      addedConnection.add(acceptConnectionRequest.getAcceptedUserName());
    }
    pendingConnection.remove(acceptConnectionRequest.getAcceptedUserName());
    connection.setConnectionIds(pendingConnection);
    connection.setAddedConnectionsUserName(addedConnection);
    connectionRepository.save(connection);
  }
  private void acceptSenderConnection(AcceptConnectionRequest acceptConnectionRequest){
    Optional<Connection> connection = connectionRepository.findConnectionByUserName(acceptConnectionRequest.getAcceptedUserName());
    if(connection.isPresent()){
      List<String> addedIds = connection.get().getAddedConnectionsUserName();
      if(addedIds == null){
        addedIds = new ArrayList<>();
      }
      addedIds.add(acceptConnectionRequest.getCurrentUserName());
      connection.get().setAddedConnectionsUserName(addedIds);
      connectionRepository.save(connection.get());
    }else{
      Connection newConnection = new Connection();
      newConnection.setUserName(acceptConnectionRequest.getAcceptedUserName());
      List<String> addedConnection = new ArrayList<>();
      addedConnection.add(acceptConnectionRequest.getCurrentUserName());
      newConnection.setAddedConnectionsUserName(addedConnection);
      connectionRepository.save(newConnection);
    }
  }

  @Override
  public void rejectConnection(AcceptConnectionRequest acceptConnectionRequest) {
  //TODO: Implement Reject Connection Scenarios
  }
}
