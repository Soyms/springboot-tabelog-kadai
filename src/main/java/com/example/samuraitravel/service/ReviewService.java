package com.example.samuraitravel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.form.ReviewEditForm;
import com.example.samuraitravel.form.ReviewRegisterForm;
import com.example.samuraitravel.repository.ReviewRepository;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findByHouse(House house) {  
        return reviewRepository.findByHouse(house);
    }

    public Review getReviewById(Integer id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found: " + id));
    }

    public void updateReview(Integer id, ReviewEditForm form) { // Long 型に変更
        Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found: " + id));
        review.setName(form.getName());
        review.setDescription(form.getDescription());
        review.setRating(Integer.toString(form.getRating()));
        reviewRepository.save(review);
    }

    public void deleteReview(Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public void saveReview(ReviewRegisterForm form) {
        Review review = new Review();
        review.setName(form.getRating());  // 訂正：登録フォームの name プロパティを対応
        review.setDescription(form.getDescription());
        review.setRating(form.getRating());
        reviewRepository.save(review);
    }
}
