package com.shivam.users.socialmedia.security;

import com.shivam.users.socialmedia.model.registeruser.User;
import com.shivam.users.socialmedia.repository.UserRepository;
import java.util.Collections;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
  private UserRepository userRepository;

  public UserDetailsServiceImp(UserRepository userRepository){
    this.userRepository = userRepository;
  }


  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findUserByUserName(s);
    if(!user.isPresent()){
      throw new UsernameNotFoundException(s);
    }
    return new org.springframework.security.core.userdetails.User(user.get().getUserName(),user.get().getPassword(),
        Collections.emptyList());
  }
}
