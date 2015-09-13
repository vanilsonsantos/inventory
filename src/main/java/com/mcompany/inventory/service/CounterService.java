package com.mcompany.inventory.service;

import com.mcompany.inventory.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Repository
public class CounterService {

    @Autowired
    private MongoTemplate mongo;

    public int getNextSequence(String collectionName) {
        if(!mongo.collectionExists("counters")) {
            mongo.createCollection("counters");
            mongo.insert(new Counter(collectionName, 0));
        }
        Query queryCounter = new Query(Criteria.where("_id").is(collectionName));
        Counter counter = mongo.findAndModify(queryCounter,
                new Update().inc("seq", 1), options().returnNew(true),
                Counter.class);
        return counter.getSeq();
    }

}