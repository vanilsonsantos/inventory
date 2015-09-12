package com.mcompany.inventory.service;

import com.mcompany.inventory.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class CounterService {

    @Autowired
    private MongoTemplate mongo;

    public int getNextSequence(String collectionName) {
        Query queryCounter = new Query(Criteria.where("_id").is(collectionName));
        Counter counter = mongo.findAndModify(queryCounter,
                new Update().inc("seq", 1), options().returnNew(true),
                Counter.class);
        return counter.getSeq();
    }

}
