package com.trentrush.codechallenge.repositories;

import com.google.cloud.firestore.Firestore;
import com.trentrush.codechallenge.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends AbstractFirestoreRepository<User>{
    protected UserRepository(Firestore firestore) {
        super(firestore, "users");
    }
}
