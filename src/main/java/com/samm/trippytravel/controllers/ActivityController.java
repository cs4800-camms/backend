package com.samm.trippytravel.controllers;

import com.samm.trippytravel.data.requests.activity.CreateActivityRequest;
import com.samm.trippytravel.data.response.activity.ActivityResponse;
import com.samm.trippytravel.repository.ActivityRepository;
import com.samm.trippytravel.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/activities")
public class ActivityController {
    private final ActivityService activityService;
    private final ActivityRepository activityRepository;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<ActivityResponse> createActivity(
            @RequestBody CreateActivityRequest createActivityRequest) {
        return new ResponseEntity<>(activityService.addActivity(createActivityRequest), HttpStatus.OK);
    }

    @GetMapping("{dayIdNumber}")
    @ResponseBody
    public ResponseEntity<List<ActivityResponse>> getActivitiesForDay(
            @PathVariable("dayIdNumber") String dayIdNumber) {
        return new ResponseEntity<>(activityService.getActivitiesForDay(dayIdNumber), HttpStatus.OK);
    }

    @DeleteMapping("/delete-all")
    public void delete() {
        activityRepository.deleteAll();
    }
}
