package com.example.springtutorial.review;

import com.example.springtutorial.movie.Movie;
import com.example.springtutorial.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    @Setter
    private int rating;

    @Setter
    private String text;

    public Review(Movie movie, User user, int rating, String text) {
        this.movie = movie;
        this.user = user;
        this.rating = rating;
        this.text = text;

    }

}
