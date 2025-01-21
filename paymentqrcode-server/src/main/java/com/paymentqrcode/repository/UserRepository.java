package com.paymentqrcode.repository;

import com.mongodb.client.MongoIterable;
import com.paymentqrcode.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Primary
@Repository("mongoUserRepository")
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
