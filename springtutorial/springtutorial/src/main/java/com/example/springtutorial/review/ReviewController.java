package com.example.springtutorial.review;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewRepository reviewRepository;

    @GetMapping("{id}")
    public ResponseEntity<ReviewDto> get(@PathVariable long id) {

        return reviewRepository.findById(id).map(review ->
                        ResponseEntity.ok(ReviewDto.from(review)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("s")
    public Iterable<Review> findBy(@RequestParam String contains,
                                       @RequestParam(name="min-rating", required = false) Double minRating) {
        return minRating == null ? reviewRepository.findByTextContainsIgnoreCase(contains) :
                reviewRepository.findByTextContainsIgnoreCaseAndRatingGreaterThanEqual(contains, minRating);

    }

    @GetMapping
    public List<ReviewDto> getAll() {
        return reviewRepository.findAll().stream().map(ReviewDto::from).toList();
    }

}
