package com.mcompany.inventory.service;

import com.mcompany.inventory.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class ItemService implements DbRepository<Item> {

    public static final String COLLECTION_NAME = "items";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void create(Item item) {
        mongoTemplate.insert(item, COLLECTION_NAME);
    }

    @Override
    public void update(Item item) {

    }

    @Override
    public void delete(int id) {
        Query queryItem = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(queryItem, COLLECTION_NAME);
    }

    @Override
    public Item findOne(BigInteger id) {
        Query queryItem = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(queryItem, Item.class, COLLECTION_NAME);
    }

    @Override
    public List<Item> findAll() {
        return mongoTemplate.findAll(Item.class, COLLECTION_NAME);
    }
}
