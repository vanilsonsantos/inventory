package com.mcompany.inventory.model.repository;

import com.mcompany.inventory.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
    Item findByName(String name);
}
