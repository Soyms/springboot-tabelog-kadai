package com.example.samuraitravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.form.ReviewEditForm;
import com.example.samuraitravel.form.ReviewRegisterForm;
import com.example.samuraitravel.repository.HouseRepository;
import com.example.samuraitravel.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    private final HouseRepository houseRepository;

    @Autowired
    public ReviewController(ReviewService reviewService, HouseRepository houseRepository) {
        this.reviewService = reviewService;
        this.houseRepository = houseRepository;
    }

    @GetMapping("/index")
    public String getReviews(@PathVariable Integer house_id, Model model) {
        House house = houseRepository.getReferenceById(house_id);
        List<Review> reviews = reviewService.findByHouse(house);
        model.addAttribute("reviews", reviews);
        model.addAttribute("id", house_id);
        return "review/index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("reviewRegisterForm", new ReviewRegisterForm());
        return "review/register";
    }

    @PostMapping("/register")
    public String registerReview(@ModelAttribute ReviewRegisterForm form) {
        reviewService.saveReview(form);
        return "redirect:/reviews/house/" + form.getHouseId();
    }

    @GetMapping("/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Review review = reviewService.getReviewById(id);
        ReviewEditForm form = new ReviewEditForm();
        form.setId(review.getId());
        form.setName(review.getName());
        form.setDescription(review.getDescription());
        form.setRating(Integer.parseInt(review.getRating()));
        model.addAttribute("reviewEditForm", form);
        return "review/edit";
    }

    @PostMapping("/edit")
    public String editReview(@PathVariable Integer id, @ModelAttribute ReviewEditForm form) {
        reviewService.updateReview(id, form);
        return "redirect:/review/house/" + form.getHouseId();
    }

    @DeleteMapping("/{reviewId}")
    public String deleteReview(@PathVariable Integer reviewId) {
        reviewService.deleteReview(reviewId);
        return "redirect:/review";
    }
    
   // @PostMapping("/submit")
   // public String submitReview(@RequestParam("rating") String rating,
                              // @RequestParam("description") String description) {
        // Reviewオブジェクトを作成してサービスクラスで保存
       // Review review = new Review();
        //review.setRating(rating);
       // review.setDescription(description);
        //reviewService.saveReview(review);
        
    //}
}
