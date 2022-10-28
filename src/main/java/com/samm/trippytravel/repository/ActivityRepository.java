package com.samm.trippytravel.repository;

import com.samm.trippytravel.data.domain.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, Long> {
}
