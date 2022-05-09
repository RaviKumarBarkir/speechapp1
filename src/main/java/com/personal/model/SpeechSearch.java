package com.personal.model;


import java.time.LocalDate;

public class SpeechSearch {

    private String speechid;
    private String body;
    private String author;
    private LocalDate startDateRange;
    private LocalDate endDateRange;
    private String subject;

    public String getSpeechid() {
        return speechid;
    }

    public void setSpeechid(String speechid) {
        this.speechid = speechid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getStartDateRange() {
        return startDateRange;
    }

    public void setStartDateRange(LocalDate startDateRange) {
        this.startDateRange = startDateRange;
    }

    public LocalDate getEndDateRange() {
        return endDateRange;
    }

    public void setEndDateRange(LocalDate endDateRange) {
        this.endDateRange = endDateRange;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "SpeechSearch{" +
                "body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", startDateRange=" + startDateRange +
                ", endDateRange=" + endDateRange +
                ", subject='" + subject + '\'' +
                '}';
    }
}