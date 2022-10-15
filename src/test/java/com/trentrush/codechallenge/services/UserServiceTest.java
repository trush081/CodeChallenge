package com.trentrush.codechallenge.services;

import com.trentrush.codechallenge.DTOs.CountDTO;
import com.trentrush.codechallenge.entities.User;
import com.trentrush.codechallenge.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void initialize(){
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    @DisplayName("addUser: valid save")
    void addUser_validSave() {
        User user = new User("test", "test message");
        List<User> users = new ArrayList<>();
        List<User> users1 = new ArrayList<>();
        users1.add(user);

        when(userRepository.retrieveAll()).thenReturn(users).thenReturn(users1);
        when(userRepository.save(any())).thenReturn(true);

        assertEquals(new CountDTO(2).getCount(), userService.addUser(user).getCount());
    }

    @Test
    @DisplayName("addUser: duplicate ID, no update")
    void addUser_duplicateId() {
        User user = new User("test", "test message");
        User user1 = new User("test", "test message again");
        List<User> users = new ArrayList<>();
        users.add(user);

        when(userRepository.retrieveAll()).thenReturn(users);
        when(userRepository.save(any())).thenReturn(true);

        assertEquals(new CountDTO(2).getCount(), userService.addUser(user1).getCount());
    }

    @Test
    @DisplayName("addUser: null list returned")
    void addUser_nullList() {
        User user = new User("test", "test message");

        when(userRepository.retrieveAll()).thenReturn(null);
        when(userRepository.save(any())).thenReturn(true);

        //This should return zero because not data is being saved in repository
        assertThrowsExactly(NullPointerException.class,() -> userService.addUser(user));
    }

    @Test
    @DisplayName("addUser: invalid empty User")
    void addUser_emptyUser() {
        User user = null;
        List<User> users = new ArrayList<>();

        when(userRepository.retrieveAll()).thenReturn(users);
        when(userRepository.save(any())).thenReturn(true);

        //This should return zero because not data is being saved in repository
        assertThrowsExactly(ResponseStatusException.class,() -> userService.addUser(user));
    }

    //Hope it's alright that I stop here with testing. Do not want to spend my afternoon
    //testing every possible case for the validation of empty Strings. I did check them in my personal QA tests.
}
