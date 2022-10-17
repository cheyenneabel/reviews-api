package com.cookies.cookieReviews.repo;


import com.cookies.cookieReviews.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
