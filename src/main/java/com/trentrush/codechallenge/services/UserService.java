package com.trentrush.codechallenge.services;

import com.trentrush.codechallenge.DTOs.CountDTO;
import com.trentrush.codechallenge.entities.User;
import com.trentrush.codechallenge.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

/**
 * Service class for User objects
 * <p>
 * Author: Trenton Rush (trush081@gmail.com)
 * Circa: 10/14/2022
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     *
     * @param user the unique object for each addition to the database
     * @return a CountDTO containing the total number of words
     */
    public CountDTO addUser(User user) {
        //check that all fields are occupied
        isValid(user);
        //find if id is duplicate from previous user and skip adding new user if duplicate
        if (!isDuplicate(user.getId(), userRepository.retrieveAll())) {
            userRepository.save(user);
            logger.info("User {} saved to database.", user);
        }
        return new CountDTO(getMessageCount( userRepository.retrieveAll()));
    }

    /**
     *
     * @param users a list of every user that has been added to the database since the application has been running
     * @return the total integer value of the number of words in each message
     */
    private int getMessageCount(List<User> users){
        int count = 0;
        //loop through each user in list
        for(User user : users){
            //counting number of words by ignoring spaces
            String[] words = user.getMessage().split("\\s+");
            count += words.length;
        }
        return count;
    }

    /**
     *
     * @param newId the id of the most recent user being added
     * @param users the current list containing each user
     * @return true if the newId matches an ID from the list of users, false otherwise
     */
    private boolean isDuplicate(String newId, List<User> users) {
        //loop through each user in list
        for (User user : users){
            //check if user IDs match and return true if they do
            if (Objects.equals(user.getId(), newId)) {
                logger.info("User {} already exists. Ignoring updated message.", newId);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param user an individual user containing id and message strings
     *
     */
    private void isValid(User user){
        //check that all fields are occupied for a user
        if (user == null ||
            (user.getId() == null || user.getId().isEmpty()) ||
            (user.getMessage() == null || user.getMessage().isEmpty())) {
            logger.warn("User is invalid!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is invalid!");
        }
    }
}
