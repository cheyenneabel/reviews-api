package com.cookies.cookieReviews.controller;

import com.cookies.cookieReviews.model.Hashtag;
import com.cookies.cookieReviews.model.Review;
import com.cookies.cookieReviews.repo.HashtagRepository;
import com.cookies.cookieReviews.repo.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HashtagController {

    private HashtagRepository hashtagRepo;
    private ReviewRepository reviewRepo;

    public HashtagController(HashtagRepository hashtagRepo, ReviewRepository reviewRepo) {
        this.hashtagRepo = hashtagRepo;
        this.reviewRepo = reviewRepo;
    }

    @GetMapping("/hashtags")
    public Iterable<Hashtag> getHashtags() {
        return hashtagRepo.findAll();
    }

    @GetMapping("/hashtags/{id}")
    public Hashtag getSingleHashtag(@PathVariable long id) {
        return hashtagRepo.findById(id).get();
    }

    @GetMapping("/hashtags/{id}/getReviews")
    public Iterable<Review> getReviews(@PathVariable long id) {
        return hashtagRepo.findById(id).get().getReviews();}

    @PostMapping("/hashtags")
    public Iterable<Hashtag> addHashtag(@RequestBody Hashtag newHashtag) {
        hashtagRepo.save(newHashtag);
        return hashtagRepo.findAll();
    }

    @PutMapping("/hashtags/{id}/addToReview/{reviewId}")
    public Review addHashtagToReview(@PathVariable long id, @PathVariable long reviewId) throws Exception {
        Optional<Hashtag> hashtag = hashtagRepo.findById(id);
        Optional<Review> review = reviewRepo.findById(reviewId);
        if (hashtag.isPresent() && review.isPresent()) {
            hashtag.get().addReviewToHashtag(review.get());
            hashtagRepo.save(hashtag.get());
        }
        else {
            throw new Exception("review/hashtag not found");
        }
        return reviewRepo.findById(reviewId).get();
    }
}
