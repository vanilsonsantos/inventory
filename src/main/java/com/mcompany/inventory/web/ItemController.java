package com.mcompany.inventory.web;

import com.mcompany.inventory.model.Item;
import com.mcompany.inventory.service.CounterService;
import com.mcompany.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ItemController {

    private ItemService itemService;
    private CounterService counter;

    @Autowired
    public ItemController(ItemService itemService, CounterService counter) {
        this.itemService = itemService;
        this.counter = counter;
    }

    @RequestMapping(value="/items/create/{name}", method = RequestMethod.POST)
    public void createItem(@PathVariable("name") String name) {
        this.itemService.create(new Item(counter.getNextSequence("items"), name));
    }

    @RequestMapping(value="/items/delete/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") int id) {
        this.itemService.delete(id);
    }

    @RequestMapping(value="/items", method = RequestMethod.GET)
    public List getItemList() {
        return itemService.findAll();
    }

    @RequestMapping(value="/items/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable("id") BigInteger id) {
        return itemService.findOne(id);
    }
}
