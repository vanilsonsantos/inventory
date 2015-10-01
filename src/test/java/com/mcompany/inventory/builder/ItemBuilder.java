package com.mcompany.inventory.builder;

import com.mcompany.inventory.model.Item;

public class ItemBuilder {

    private String name = "new item";
    private int id = 1;

    public Item build() {
        return new Item(id, name);
    }

    public ItemBuilder withName(String nameExpectedItem) {
        this.name = nameExpectedItem;
        return this;
    }

    public ItemBuilder withId(int id) {
        this.id = id;
        return this;
    }
}
