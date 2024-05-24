package com.example.springtutorial;

import com.example.springtutorial.movie.Movie;
import com.example.springtutorial.movie.MovieRepository;
import com.example.springtutorial.review.Review;
import com.example.springtutorial.review.ReviewRepository;
import com.example.springtutorial.user.MARole;
import com.example.springtutorial.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {
    private final MovieRepository movieRepository;
    private final UserService userService;
    private final ReviewRepository reviewRepository;

    @Override
    public void run(String... args) {
        if (movieRepository.count() == 0) {
            var up = new Movie("Up");
            var citizenKane = new Movie("Citizen Kane");
            var theGrandBudapest = new Movie("The Grand Budapest Hotel");
            var starWars = new Movie("Star Wars");
            movieRepository.saveAll(List.of(up, citizenKane, theGrandBudapest, starWars));

            var me = userService.save("TheWub", "secret", MARole.ADMIN);
            var testUser = userService.save("nn", "password", MARole.USER);


            var myCitizenKaneReview = new Review(citizenKane, me, 2, "famous, but disappointing");
            var myUpReview = new Review(up, me, 5, "touching, surprising, and funny");
            var testGrandBudapestReview = new Review(theGrandBudapest, testUser, 3, "sometimes funny, but mostly mwuh");
            var testUpReview = new Review(up, testUser, 1, "I don't like cartoons");
            reviewRepository.saveAll(List.of(myCitizenKaneReview, myUpReview, testGrandBudapestReview, testUpReview));
        }
    }
}
