package com.cookies.cookieReviews.controller;

import com.cookies.cookieReviews.model.Review;
import com.cookies.cookieReviews.repo.ReviewRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {
    private ReviewRepository reviewRepo;

    public ReviewController(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @GetMapping("/reviews")
    public Iterable<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @GetMapping("/reviews/{id}")
    public Review getSingleReview(@PathVariable long id) {
        return reviewRepo.findById(id).get();
    }

    @PostMapping("/reviews")
    public Iterable<Review> addNewReview(@RequestBody Review newReview){
        reviewRepo.save(newReview);
        return reviewRepo.findAll();
    }

}
