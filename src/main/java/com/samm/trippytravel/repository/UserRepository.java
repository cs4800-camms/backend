package com.samm.trippytravel.repository;

import com.samm.trippytravel.data.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, Long> {
    @Query(value="{'_id' : ?0}", delete = true)
    User deleteById(String id);
}
