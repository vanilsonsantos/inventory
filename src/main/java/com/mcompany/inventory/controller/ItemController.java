package com.mcompany.inventory.controller;

import com.mcompany.inventory.model.Item;
import com.mcompany.inventory.service.ItemService;
import com.mcompany.inventory.view.ItemRequestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/inventory/item/create", method = RequestMethod.POST, consumes = "*/*")
    public Item createItem(@Valid @RequestBody ItemRequestResource resource) {
        return this.itemService.createItem(resource);
    }
}
