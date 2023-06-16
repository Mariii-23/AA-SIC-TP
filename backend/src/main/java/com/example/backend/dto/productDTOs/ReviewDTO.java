package com.example.backend.dto.productDTOs;

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
