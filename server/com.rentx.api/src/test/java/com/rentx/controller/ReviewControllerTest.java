package com.rentx.controller;

import com.rentx.businessservices.ReviewService;
import com.rentx.config.UserAuthenticationProvider;
import com.rentx.dataaccess.repository.ProductRealRepository;
import com.rentx.dataaccess.repository.UserRepository;
import com.rentx.dtos.UserDto;
import com.rentx.entities.ProductReal;
import com.rentx.entities.Review;
import com.rentx.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReviewControllerTest {

    private ReviewController reviewController;

    @Mock
    private ReviewService reviewService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRealRepository productRealRepository;

    @Mock
    private UserAuthenticationProvider userAuthenticationProvider;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reviewController = new ReviewController(reviewService, userAuthenticationProvider, userRepository,productRealRepository);
    }

    @Test
    public void testGetReviewForProduct() {
        int productID = 1;
        List<Review> reviews = new ArrayList<>();
        when(reviewService.getReviewForProduct(productID)).thenReturn(reviews);

        ResponseEntity<List<Review>> responseEntity = reviewController.getReviewForProduct(productID);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(reviews, responseEntity.getBody());
    }

    @Test
    public void testPostReview() {
        Review review = new Review();
        String authorizationHeader = "Bearer token";
        int product_id = 1;
        UserDto userDto = new UserDto();
        User user = new User();
        when(userAuthenticationProvider.getUserByToken("token")).thenReturn(userDto);
        when(userRepository.findByUserID(userDto.getUserID())).thenReturn(user);
        when(productRealRepository.findById(product_id)).thenReturn(Optional.of(new ProductReal()));
        ResponseEntity<?> responseEntity = reviewController.postReview(review, authorizationHeader, product_id);

        verify(userAuthenticationProvider, times(1)).getUserByToken("token");
        verify(userRepository, times(1)).findByUserID(userDto.getUserID());
        verify(reviewService, times(1)).addReview(review);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
}
