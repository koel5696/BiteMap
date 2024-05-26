package com.aunae.bitemap.service;

import com.aunae.bitemap.DTO.ReviewDTO;
import com.aunae.bitemap.entity.Place;
import com.aunae.bitemap.entity.Review;
import com.aunae.bitemap.repository.PlaceRepository;
import com.aunae.bitemap.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional
    public void addReview(String placeName, String reviewText, int rating) {
        Place place = placeRepository.findByName(placeName)
                .orElseGet(() -> {
                    Place newPlace = new Place();
                    newPlace.setName(placeName);
                    return placeRepository.save(newPlace);
                });

        Review review = new Review();
        review.setPlace(place);
        review.setReviewText(reviewText);
        review.setRating(rating);
        reviewRepository.save(review);
    }

    public List<Review> getReviews(Long placeId) {
        return reviewRepository.findByPlaceId(placeId);
    }
}