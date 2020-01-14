package com.shivam.users.socialmedia.service.connection;

import com.shivam.users.socialmedia.model.connection.Connection;
import com.shivam.users.socialmedia.model.connection.requestmodel.AcceptConnectionRequest;
import com.shivam.users.socialmedia.model.connection.requestmodel.SetConnectionRequest;
import java.util.List;
import java.util.Optional;

public interface ConnectionServiceLayer {
  void addConnectionRequest(SetConnectionRequest setConnectionRequest);
  Optional<Connection> getConnectionRequest(String userName);
  List<Connection> findAllConnections();
  void acceptConnection(AcceptConnectionRequest acceptConnectionRequest);
  void rejectConnection(AcceptConnectionRequest acceptConnectionRequest);

}
