package com.samm.trippytravel.repository;

import com.samm.trippytravel.data.domain.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, Long> {
    @Query(value="{ 'day_id' : ObjectId( ?0 )}")
    List<Activity> getActivitiesByDayId(String dayId);
}
