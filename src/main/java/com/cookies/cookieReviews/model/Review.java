package com.cookies.cookieReviews.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    private int rating;
    private String flavor;
    private String shape;

    @ManyToOne
    @JsonIgnore
    private Category category;

    @ManyToMany(mappedBy = "reviews")
    private Collection<Hashtag> hashtag;

    public Collection<Hashtag> getHashtag() {
        return hashtag;
    }

    public Review(int rating, String flavor, String shape, Category category) {
        this.rating = rating;
        this.flavor = flavor;
        this.shape = shape;
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

    public int getRating() { return rating;
    }

    public String getFlavor() {
        return flavor;
    }


    public String getShape() {
        return shape;
    }

    public Category getCategory() {
        return category;
    }
}
