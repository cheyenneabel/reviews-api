package com.cookies.cookieReviews.controller;

import com.cookies.cookieReviews.model.Category;
import com.cookies.cookieReviews.model.Review;
import com.cookies.cookieReviews.repo.CategoryRepository;
import com.cookies.cookieReviews.repo.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CategoryController {

    private CategoryRepository categoryRepo;
    private ReviewRepository reviewRepo;

    public CategoryController(CategoryRepository categoryRepo, ReviewRepository reviewRepo) {
        this.categoryRepo = categoryRepo;
        this.reviewRepo = reviewRepo;
    }

    @GetMapping("/categories")
    public Iterable<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category getSingleCategory(@PathVariable long id) {
        return categoryRepo.findById(id).get();
    }

    @PostMapping("/categories")
    public Iterable<Category> addCategory(@RequestBody Category category) {
        categoryRepo.save(category);
        return categoryRepo.findAll();
    }

    @PutMapping("/categories/{id}/addToReview/{reviewId}")
    public Iterable<Category> addCategoryToReview(@PathVariable long id, @PathVariable long reviewId) throws Exception {
        Optional<Category> category = categoryRepo.findById(id);
        Optional<Review> review = reviewRepo.findById(reviewId);
        if (category.isPresent() && review.isPresent()) {
            review.get().setCategory(category.get());
            reviewRepo.save(review.get());
        }
        else {
            throw new Exception("Category/Review does not exist");
        }
        return categoryRepo.findAll();
    }

}
