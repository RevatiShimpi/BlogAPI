package com.BlogAPI.API.repository;

import com.BlogAPI.API.entities.entities;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepo extends MongoRepository<entities, Integer> {
    @Query("{'title':?0}")
    Optional<entities> findByTitle(String title);


}
