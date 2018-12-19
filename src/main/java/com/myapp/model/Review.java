package com.myapp.model;

import java.util.Date;

public class Review extends BaseEntity{
    private Product product;
    private User user;
    private Date reviewDate;
    private String reviewText;

    public Review() {

    }

    public Review(Integer id, Product product, User user, Date reviewDate, String reviewText) {
        super(id);
        this.product = product;
        this.user = user;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
