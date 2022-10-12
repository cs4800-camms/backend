package com.samm.trippytravel.repository;

import com.samm.trippytravel.data.domain.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends MongoRepository<Trip, Long> {

}