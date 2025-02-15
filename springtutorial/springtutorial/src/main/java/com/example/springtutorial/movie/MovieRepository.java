package com.example.springtutorial.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleIgnoringCaseContaining(String title);

    boolean existsByTitleIgnoringCaseContaining(String title);
}
