package com.shivam.users.socialmedia.repository;

import com.shivam.users.socialmedia.model.connection.Connection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends MongoRepository<Connection,String> {

}
