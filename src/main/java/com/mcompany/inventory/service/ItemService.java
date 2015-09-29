package com.mcompany.inventory.service;

import com.mcompany.inventory.model.CounterRepository;
import com.mcompany.inventory.model.Item;
import com.mcompany.inventory.model.ItemRepository;
import com.mcompany.inventory.view.ItemRequestResource;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Item createItem(ItemRequestResource itemResource) {
        if(itemRepository.findOne("") != null) {
            throw new ItemAlreadyExistsException("You can create an item with the same name");
        }
        return itemRepository.save(Item.item(counterRepository.getNextSequence("item"), itemResource.getName()));
    }
}
