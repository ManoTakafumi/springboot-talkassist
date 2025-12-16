package com.example.talkassist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String keywords;

    public Topic() {

    }

    public Topic(String content, String keywords) {
        this.content = content;
        this.keywords = keywords;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
