package com.mcompany.inventory.service;

import com.mcompany.inventory.model.Item;
import com.mcompany.inventory.model.repository.CounterRepository;
import com.mcompany.inventory.model.repository.ItemRepository;
import com.mcompany.inventory.view.ItemRequestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private CounterRepository counterRepository;
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, CounterRepository counterRepository) {
        this.itemRepository = itemRepository;
        this.counterRepository = counterRepository;
    }

    public ResponseEntity createItem(ItemRequestResource itemResource) {
        if(itemRepository.findByName(itemResource.getName()) != null) {
            return new ResponseEntity("You can not create an item with the same name", HttpStatus.OK);
        }
        Item itemCreated = itemRepository.save(Item.item(counterRepository.getNextSequence("item"), itemResource.getName()));
        return new ResponseEntity(itemCreated, HttpStatus.OK);
    }
}
