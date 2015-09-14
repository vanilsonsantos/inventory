package com.mcompany.inventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
public class Item {

    @Id
    private BigInteger id;

    private String name;

    public Item(BigInteger id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
