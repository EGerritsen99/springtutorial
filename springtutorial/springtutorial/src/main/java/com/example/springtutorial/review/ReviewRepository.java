package com.example.springtutorial.review;

import com.example.springtutorial.movie.Movie;
import com.example.springtutorial.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

//    Optional<Review> findByUserAndMovie(User user, Movie movie);

    Iterable<Review> findByTextContainsIgnoreCase(String query);
    Iterable<Review> findByTextContainsIgnoreCaseAndRatingGreaterThanEqual(String query, Double minRating);

}
