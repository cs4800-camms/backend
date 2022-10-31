package com.samm.trippytravel.repository;

import com.samm.trippytravel.data.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
