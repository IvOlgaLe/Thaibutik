package com.myapp.model;

import java.util.Date;

public class Comment {
    private int commentId;
    private int productId;
    private String productName;
    private int userId;
    private String userName;
    private Date commentDate;
    private String commentText;

    public Comment() {

    }

    public Comment(int commentId, int productId, String productName, int userId, String userName,
                   Date commentDate, String commentText) {
        this.commentId = commentId;
        this.productId = productId;
        this.productName = productName;
        this.userId = userId;
        this.userName = userName;
        this.commentDate = commentDate;
        this.commentText = commentText;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
