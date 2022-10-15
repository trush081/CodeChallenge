package com.trentrush.codechallenge.repositories;

import com.trentrush.codechallenge.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class to interact with users
 * <p>
 * Author: Trenton Rush (trush081@gmail.com)
 * Circa: 10/14/2022
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
