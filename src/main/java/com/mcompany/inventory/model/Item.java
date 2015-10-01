package com.mcompany.inventory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
public class Item {

    @Id
    private int Id;

    @Getter
    private String name;

    public Item(int Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    public static Item item(int Id, String name) {
        return new Item(Id, name);
    }
}
