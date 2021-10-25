package com.ajsw.microdb.dto;

import java.util.Date;

public class CommentRequest {
    private String applicantId;
    private String bidderId;
    private String commentDescription;
    private int score;
    private Date date;

    public CommentRequest() {
    }

    public CommentRequest(String applicantId, String bidderId, String commentDescription, int score, Date date) {
        this.applicantId = applicantId;
        this.bidderId = bidderId;
        this.commentDescription = commentDescription;
        this.score = score;
        this.date = date;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getBidderId() {
        return bidderId;
    }

    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
