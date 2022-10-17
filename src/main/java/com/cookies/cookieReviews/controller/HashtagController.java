package com.cookies.cookieReviews.controller;

import com.cookies.cookieReviews.model.Hashtag;
import com.cookies.cookieReviews.repo.HashtagRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashtagController {

    private HashtagRepository hashtagRepo;

    public HashtagController(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    @GetMapping("/hashtags")
    public Iterable<Hashtag> getHashtags() {
        return hashtagRepo.findAll();
    }

    @GetMapping("/hashtags/{id}")
    public Hashtag getSingleHashtag(@PathVariable long id) {
        return hashtagRepo.findById(id).get();
    }
}
