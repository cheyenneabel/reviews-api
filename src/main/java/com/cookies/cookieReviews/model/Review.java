package com.cookies.cookieReviews.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    private String author;
    private String rating;
    private String flavor;
    private String reviewText;

    @ManyToOne
    @JsonIgnore
    private Category category;

    @ManyToMany(mappedBy = "reviews")
    private Collection<Hashtag> hashtag;
    public Collection<Hashtag> getHashtag() {
        return hashtag;
    }

    public Review(String author, String rating, String flavor, String reviewText, Category category) {
        this.author = author;
        this.rating = rating;
        this.flavor = flavor;
        this.reviewText = reviewText;
        this.category = category;
    }

    public Review() {

    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public long getId() {
        return id;
    }
    public String getRating() { return rating; }
    public String getFlavor() {
        return flavor;
    }
    public String getAuthor() {
        return author;
    }

    public String getReviewText() {
        return reviewText;
    }

    public Category getCategory() {
        return category;
    }
}
