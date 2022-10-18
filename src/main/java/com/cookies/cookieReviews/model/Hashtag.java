package com.cookies.cookieReviews.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String description;

    @ManyToMany
    @JsonIgnore
    private Collection<Review> reviews;

    public Hashtag(String description, Review... reviews) {
        this.description = description;
        this.reviews = Arrays.asList(reviews);
    }
    public Hashtag() {

    }
    public void addReviewToHashtag(Review review) {
        reviews.add(review);
    }
    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}
