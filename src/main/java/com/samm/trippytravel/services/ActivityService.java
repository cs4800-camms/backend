package com.samm.trippytravel.services;

import com.samm.trippytravel.data.domain.Activity;
import com.samm.trippytravel.data.requests.activity.CreateActivityRequest;
import com.samm.trippytravel.data.requests.activity.UpdateActivityRequest;
import com.samm.trippytravel.data.response.ActivityResponse;
import com.samm.trippytravel.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityResponse addActivity(CreateActivityRequest createActivityRequest) {
        return toActivityResponse(activityRepository.insert(Activity.builder()
                .day_id(createActivityRequest.getDay_id())
                .checked(createActivityRequest.isChecked())
                .name(createActivityRequest.getName())
                .location(createActivityRequest.getLocation())
                .build()));
    }

    public List<ActivityResponse> getActivitiesForDay(String dayIdNumber) {
        return toListActivityResponse(activityRepository.getActivitiesByDayId(dayIdNumber));
    }

    public ActivityResponse deleteActivity(String activityIdNumber) {
        return toActivityResponse(activityRepository.deleteById(activityIdNumber));
    }

    public ActivityResponse updateActivity(String activityIdNumber, UpdateActivityRequest updateActivityRequest) {
        return toActivityResponse(activityRepository.save(Activity.builder()
                ._id(activityIdNumber)
                .day_id(updateActivityRequest.getDay_id())
                .checked(updateActivityRequest.isChecked())
                .name(updateActivityRequest.getName())
                .location(updateActivityRequest.getLocation())
                .build()));
    }

    private ActivityResponse toActivityResponse(Activity activity) {
        return ActivityResponse.builder()
                ._id(activity.get_id())
                .day_id(activity.getDay_id().toString())
                .checked(activity.isChecked())
                .name(activity.getName())
                .location(activity.getLocation())
                .build();
    }

    private List<ActivityResponse> toListActivityResponse(List<Activity> activityList) {
        return activityList.stream()
                .map(this::toActivityResponse)
                .collect(toList());
    }
}
