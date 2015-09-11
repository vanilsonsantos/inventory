package com.mcompany.inventory.web;

import com.mcompany.inventory.model.Item;
import com.mcompany.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value="/items/create/{name}", method = RequestMethod.POST)
    public void createItem(@PathVariable("name") String name) {
        this.itemService.create(new Item(3L, name));
    }

    @RequestMapping(value="/items/delete/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") Long id) {
        this.itemService.delete(id);
    }

    @RequestMapping(value="/items", method = RequestMethod.GET)
    public List getItemList() {
        return itemService.findAll();
    }

    @RequestMapping(value="/items/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable("id") Long id) {
        return itemService.findOne(id);
    }
}
