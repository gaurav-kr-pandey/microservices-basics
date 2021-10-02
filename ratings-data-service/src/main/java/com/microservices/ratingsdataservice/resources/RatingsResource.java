package com.microservices.ratingsdataservice.resources;

import com.microservices.ratingsdataservice.models.RatingsData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingsResource {

    @GetMapping("/{movieId}")
    public RatingsData getRatingsData(@PathVariable("movieId") String movieId){
        return new RatingsData(movieId,4);
    }

    @GetMapping("/")
    public List<RatingsData> getRatings(){
        return Arrays.asList(
                new RatingsData("foo",4),
                new RatingsData("bar", 3),
                new RatingsData("zig",2),
                new RatingsData("zag", 3)
        );
    }
}
