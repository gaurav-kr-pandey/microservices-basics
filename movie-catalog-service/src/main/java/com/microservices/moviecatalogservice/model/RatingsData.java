package com.microservices.moviecatalogservice.model;

public class RatingsData {

    private String movieId;
    private int rating;

    public RatingsData() {
    }

    public RatingsData(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
