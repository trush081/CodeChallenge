package com.trentrush.codechallenge.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO class for count
 * Note: I'm not in love with DTOs, but it made the most sense in this situation so that the count object
 *       would show up on the swagger docs. Json serialization is what I would have done otherwise due to
 *       the small amount of data being returned.
 * <p>
 * Author: Trenton Rush (trush081@gmail.com)
 * Circa: 10/14/2022
 */
public class CountDTO {

    @Schema(description = "Total number of words from each message of every user", example = "6")
    private int count;

    public CountDTO(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
