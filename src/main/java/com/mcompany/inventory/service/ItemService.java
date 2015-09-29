package com.mcompany.inventory.service;

import com.mcompany.inventory.model.Item;
import com.mcompany.inventory.model.ItemRepository;
import com.mcompany.inventory.view.ItemRequestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(ItemRequestResource itemResource) {
        return itemRepository.save(Item.item(itemResource.getName()));
    }
}
