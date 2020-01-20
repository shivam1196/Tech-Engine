package com.shivam.users.socialmedia.service.userconnections;

import com.shivam.users.socialmedia.model.connection.Connection;
import com.shivam.users.socialmedia.model.connection.requestmodel.AcceptConnectionRequest;
import com.shivam.users.socialmedia.model.connection.requestmodel.SetConnectionRequest;
import com.shivam.users.socialmedia.model.registeruser.User;
import java.util.List;
import java.util.Optional;

public interface UsersConnectionServiceLayer {

  void registerUser(User user);
  List<User> findAllUser();
  Optional<User> findUserbyUserName(String userName);

  void addConnectionRequest(SetConnectionRequest setConnectionRequest);
  Optional<Connection> getConnectionRequest(String userName);
  List<Connection> findAllConnections();
  void acceptConnection(AcceptConnectionRequest acceptConnectionRequest);
  void rejectConnection(AcceptConnectionRequest acceptConnectionRequest);

}
