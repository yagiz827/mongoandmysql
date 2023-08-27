package com.example.demo.mongooo;

import com.example.demo.mongooo.MTournament;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



public interface MRepo extends MongoRepository<MTournament, String> {
}