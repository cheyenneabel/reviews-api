package com.cookies.cookieReviews.repo;

import com.cookies.cookieReviews.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
