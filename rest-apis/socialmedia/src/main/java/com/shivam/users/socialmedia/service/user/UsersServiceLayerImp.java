package com.shivam.users.socialmedia.service.user;

import com.shivam.users.socialmedia.model.registeruser.User;
import com.shivam.users.socialmedia.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceLayerImp implements UsersServiceLayer {
  @Autowired
  UserRepository userRepository;

  @Override
  public void registerUser(User user) {
    userRepository.save(user);
  }

  @Override
  public List<User> findAllUser() {
    return userRepository.findAll();
  }


}
