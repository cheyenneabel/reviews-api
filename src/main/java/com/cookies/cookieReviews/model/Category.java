package com.cookies.cookieReviews.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;
    private String categoryName;
    private String occasion;

    @OneToMany(mappedBy = "category")
    private Collection<Review> reviews;

    public Category(String categoryName, String occasion) {
        this.categoryName = categoryName;
        this.occasion = occasion;
    }

    public long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getOccasion() {
        return occasion;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public Category() {

    }
}
