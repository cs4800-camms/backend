package com.example.restservice;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.FilenameUtils;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private Trip sampleTrip = new Trip(counter.incrementAndGet(), "Summer Trip", "Japan & Philippines");

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/trip")
    public Trip trip(@RequestParam(value = "destination", defaultValue = "United States") String destination) {
        return new Trip(counter.incrementAndGet(), "Trip"+counter.get(), destination);
    }

    @GetMapping("/gettrip")
    public String getTrip() {
        return sampleTrip.getName() + "'s destinations are " + sampleTrip.getDestination();
    }

    @GetMapping("/bye")
    public String bye(){
        return "Good bye!";
    }

    @GetMapping("/vampire")
    public String vampire(){
        return "say it...out loud...vampire";
    }

    @GetMapping("/dog")
    public String dog(){
        return "This is a normal dog:D ";
    }

    @GetMapping("/commons")
    //normalizes a filename by removing double dot segments
    public String commons() {
        String filename = "C:/commons/io/../lang/trippytravel.html";
        String normalized = FilenameUtils.normalize(filename);
        return normalized;

    }

    @GetMapping("/jsoup")
    public String jsoup() throws IOException {
        Document doc = Jsoup.connect("https://commons.wikimedia.org/wiki/Main_Page").get();
        String title = doc.title();
        return title;

    }


}
