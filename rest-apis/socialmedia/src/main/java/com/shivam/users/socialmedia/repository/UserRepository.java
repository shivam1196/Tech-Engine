package com.shivam.users.socialmedia.repository;

import com.shivam.users.socialmedia.model.registeruser.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User,String> {
  Optional<User>findUserByUserName(String userName);

}
