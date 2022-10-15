package com.trentrush.codechallenge.entities;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Entity class for users
 * <p>
 * Author: Trenton Rush (trush081@gmail.com)
 * Circa: 10/14/2022
 */

public class User {

    @DocumentId
    @Schema(description = "Unique id of every user", example = "123")
    private String id;

    @Schema(description = "A note or collection of words from every user", example = "Hello World")
    private String message;

    public User() {

    }

    public User(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
