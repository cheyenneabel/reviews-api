package com.cookies.cookieReviews;

import com.cookies.cookieReviews.model.Category;
import com.cookies.cookieReviews.model.Hashtag;
import com.cookies.cookieReviews.model.Review;
import com.cookies.cookieReviews.repo.CategoryRepository;
import com.cookies.cookieReviews.repo.HashtagRepository;
import com.cookies.cookieReviews.repo.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    private ReviewRepository reviewRepo;
    private CategoryRepository categoryRepo;
    private HashtagRepository hashtagRepo;

    public Populator(ReviewRepository reviewRepo, CategoryRepository categoryRepo, HashtagRepository hashtagRepo) {

        this.reviewRepo = reviewRepo;
        this.categoryRepo = categoryRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category("Store bought", "Snack");
        categoryRepo.save(category1);
        Category category2 = new Category("American Classic", "Oven Fresh");
        categoryRepo.save(category2);
        Category category3 = new Category("French", "Treat");
        categoryRepo.save(category3);

        Review review1 = new Review(7, "Oreo", "Sandwich", category1);
        reviewRepo.save(review1);
        Review review2 = new Review(10, "Chocolate Chip", "Drop Cookie", category2);
        reviewRepo.save(review2);
        Review review3 = new Review(4, "Macaron", "Sandwich", category3);
        reviewRepo.save(review3);
        Review review4 = new Review(7, "Brownie", "bar", category2);
        reviewRepo.save(review4);

        Hashtag hashtag1 = new Hashtag("ChocolateTherapy", review2);
        hashtagRepo.save(hashtag1);
        Hashtag hashtag2 = new Hashtag("FancyTreat", review3, review4);
        hashtagRepo.save(hashtag2);
        Hashtag hashtag3 = new Hashtag("HereForTheFrosting", review3, review1);
        hashtagRepo.save(hashtag3);

    }
}
