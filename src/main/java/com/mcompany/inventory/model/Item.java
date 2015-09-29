package com.mcompany.inventory.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;

public class Item {

    @Id
    private String Id;

    @Getter
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public static Item item(String name) {
        return new Item(name);
    }
}
