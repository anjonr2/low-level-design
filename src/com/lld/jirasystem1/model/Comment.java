package com.lld.jirasystem1.model;

import com.lld.jirasystem1.observer.User;

import java.time.Instant;

public class Comment {
    private final String id;
    private final String content;
    private final User author;
    private final Instant timeStamp;

    public Comment(String id, String content, User author, Instant timeStamp) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
