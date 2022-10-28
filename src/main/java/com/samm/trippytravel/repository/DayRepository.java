package com.samm.trippytravel.repository;

import com.samm.trippytravel.data.domain.Day;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository extends MongoRepository<Day, Long> {
    @Query(value="{ 'trip_id' : ObjectId( ?0 )}")
    List<Day> getDaysByTripId(String tripId);
}