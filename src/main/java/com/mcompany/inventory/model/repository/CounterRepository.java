package com.mcompany.inventory.model.repository;

import com.mcompany.inventory.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Repository
public class CounterRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Counter getLastIdGenerated(String collectionName) {
        Query queryCounter = new Query(Criteria.where("_id").is(collectionName));
        Counter count = mongoTemplate.findOne(queryCounter, Counter.class, "counters");
        return count;
    }

    public int getNextSequence(String collectionName) {
        Query queryCounter = new Query(Criteria.where("_id").is(collectionName));
        Counter counter = mongoTemplate.findAndModify(queryCounter,
         new Update().inc("sequence", 1), options().returnNew(true),
           Counter.class, "counters");
        return counter.getSequence();
    }
}
