package com.samm.trippytravel.controllers;

import com.samm.trippytravel.data.requests.day.CreateDayRequest;
import com.samm.trippytravel.data.response.day.DayResponse;
import com.samm.trippytravel.repository.DayRepository;
import com.samm.trippytravel.services.DayService;
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
@RequestMapping("/days")
public class DayController {
    private final DayService dayService;
    private final DayRepository dayRepository;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<DayResponse> createDay(
            @RequestBody CreateDayRequest createDayRequest) {
        return new ResponseEntity<>(dayService.addDay(createDayRequest), HttpStatus.OK);
    }

    @GetMapping("{tripIdNumber}")
    @ResponseBody
    public ResponseEntity<List<DayResponse>> getDaysForTrip(
            @PathVariable("tripIdNumber") String tripIdNumber) {
        return new ResponseEntity<>(dayService.getDaysForTrip(tripIdNumber), HttpStatus.OK);
    }

    @DeleteMapping("{dayIdNumber}")
    @ResponseBody
    public ResponseEntity<DayResponse> deleteDay(
            @PathVariable("dayIdNumber") String dayIdNumber) {
        return new ResponseEntity<>(dayService.deleteDay(dayIdNumber), HttpStatus.OK);
    }

    @DeleteMapping("/delete-all")
    public void delete() {
        dayRepository.deleteAll();
    }
}
