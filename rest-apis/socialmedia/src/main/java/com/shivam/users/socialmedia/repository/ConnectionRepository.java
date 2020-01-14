package com.shivam.users.socialmedia.repository;

import com.shivam.users.socialmedia.model.connection.Connection;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends MongoRepository<Connection,String> {

  Optional<Connection> findConnectionByUserName(String userName);
}
