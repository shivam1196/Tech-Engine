package com.shivam.users.socialmedia.service.user;

import com.shivam.users.socialmedia.model.registeruser.User;
import java.util.List;
import java.util.Optional;

public interface UsersServiceLayer {

  void registerUser(User user);
  List<User> findAllUser();
  Optional<User> findUserbyUserName(String userName);

}
