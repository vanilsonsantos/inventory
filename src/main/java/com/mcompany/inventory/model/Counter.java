package com.mcompany.inventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counters")
public class Counter {

    @Id
    private String id;

    private int seq;

    public Counter(String id, int seq) {
        this.id = id;
        this.seq = seq;
    }

    public void setSeq(int inc) {
        this.seq = inc;
    }

    public int getSeq() {
        return this.seq;
    }

}
