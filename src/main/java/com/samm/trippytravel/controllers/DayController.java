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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @DeleteMapping("/delete-all")
    public void delete() {
        dayRepository.deleteAll();
    }
}
