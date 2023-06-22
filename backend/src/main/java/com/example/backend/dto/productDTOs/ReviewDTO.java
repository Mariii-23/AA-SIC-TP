package com.example.backend.dto.productDTOs;

import com.example.backend.model.Review;

public class ReviewDTO {
    private int classification;
    private String comment;
    private String username;

    public ReviewDTO() {
    }

    public ReviewDTO(int classification, String comment, String username) {
        this.classification = classification;
        this.comment = comment;
        this.username = username;
    }

    public ReviewDTO(Review review) {
        this.classification = review.getClassification();
        this.comment = review.getComment();
        this.username = review.getAuthor().getName();
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
