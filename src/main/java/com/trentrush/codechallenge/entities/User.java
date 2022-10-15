package com.trentrush.codechallenge.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for users
 * <p>
 * Author: Trenton Rush (trush081@gmail.com)
 * Circa: 10/14/2022
 */
@Entity
@Table(name = "users")
public class User {

    @Id
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
