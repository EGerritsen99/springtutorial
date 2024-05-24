package com.example.springtutorial.movie;

import com.example.springtutorial.review.ReviewDto;

import java.util.List;
import java.util.OptionalDouble;

public record MovieDto(Long id, String title, List<ReviewDto> reviews) {

    public static MovieDto from(Movie movie) {
        return new MovieDto(movie.getId(), movie.getTitle(), movie.getReviews().stream().map(ReviewDto::from).toList());
    }

    public OptionalDouble getAverageRating() {
        return reviews.stream().mapToDouble(ReviewDto::rating).average();
    }
}
