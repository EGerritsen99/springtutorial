package com.example.springtutorial.movie;

import com.example.springtutorial.review.Review;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private String title;

    @OneToMany(mappedBy = "movie")
    private final Set<Review> reviews = new HashSet<>();

    public Movie(String title) {
        this.title = title;
    }

}
