package com.microservices.movieinfoservice.resources;

import com.microservices.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    private final Map<String,Movie> staticMovieData = new HashMap<>();

    @PostConstruct
    void init(){
        staticMovieData.put("foo",new Movie("foo","Transformer - I","Description - I" ));
        staticMovieData.put("bar",new Movie("bar","Transformer - II","Description - II" ));
        staticMovieData.put("zig",new Movie("zig","Transformer - III","Description - III" ));
        staticMovieData.put("zag",new Movie("zag","Transformer - IV","Description - IV" ));
    }


    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        return staticMovieData.get(movieId);

    }
}
