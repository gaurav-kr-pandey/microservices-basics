package com.microservices.moviecatalogservice.resource;

import com.microservices.moviecatalogservice.model.CatalogItem;
import com.microservices.moviecatalogservice.model.Movie;
import com.microservices.moviecatalogservice.model.RatingsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    //@Autowired
    //DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;
    @Value("${spring.application.name}")
    private String applicationName;
    private static final String MOVIE_INFO_URI = "http://movie-info-service/movie/";
    private static final String RATINGS_INFO_URI = "http://ratings-data-service/rating/";

    @GetMapping("/{userId}")
    public List<CatalogItem> getMovieCatalog(@PathVariable("userId") String userId){
        ResponseEntity<List<RatingsData>> data =    restTemplate.exchange(RATINGS_INFO_URI, HttpMethod.GET, null, new   ParameterizedTypeReference<List<RatingsData>>() {});
        List<RatingsData> ratings = data.getBody();
        //System.out.println("\n" +discoveryClient.getInstances(applicationName)+ "\n");
        return ratings.stream().map(rating -> {
                    Movie movie = restTemplate.getForObject(MOVIE_INFO_URI+rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
