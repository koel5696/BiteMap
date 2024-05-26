package com.aunae.bitemap.controller;

import com.aunae.bitemap.DTO.ReviewDTO;
import com.aunae.bitemap.entity.Review;
import com.aunae.bitemap.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/reviews")
    public void addReview(@RequestBody ReviewDTO reviewDTO) {
        reviewService.addReview(
                reviewDTO.getPlaceName(),
                reviewDTO.getReviewText(),
                reviewDTO.getRating()
        );
    }

    @GetMapping("/reviews")
    public List<Review> getReviews(@RequestParam Long placeId) {
        return reviewService.getReviews(placeId);
    }
}
