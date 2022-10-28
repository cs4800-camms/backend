package com.samm.trippytravel.services;

import com.samm.trippytravel.data.domain.Activity;
import com.samm.trippytravel.data.requests.activity.CreateActivityRequest;
import com.samm.trippytravel.data.response.activity.ActivityResponse;
import com.samm.trippytravel.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private ActivityResponse toActivityResponse(Activity activity) {
        return ActivityResponse.builder()
                ._id(activity.get_id())
                .day_id(activity.getDay_id().toString())
                .checked(activity.isChecked())
                .name(activity.getName())
                .location(activity.getLocation())
                .build();
    }
}
