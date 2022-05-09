package com.personal.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Speech")
public class Speech implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "speech_seq")
    @GenericGenerator(
            name = "speech_seq",
            strategy = "com.personal.entity.SpeechGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = SpeechGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = SpeechGenerator.VALUE_PREFIX_PARAMETER, value = "Speech "),
                    @org.hibernate.annotations.Parameter(name = SpeechGenerator.NUMBER_FORMAT_PARAMETER, value = "%01d") })
    private String id;
    private String body;
    private String author;
    private String createdDate;
    private String subject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}