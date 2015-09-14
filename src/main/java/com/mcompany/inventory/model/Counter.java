package com.mcompany.inventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "counters")
public class Counter {

    @Id
    private String id;

    private BigInteger seq;

    public Counter(String id, BigInteger seq) {
        this.id = id;
        this.seq = seq;
    }

    public void setSeq(BigInteger inc) {
        this.seq = inc;
    }

    public BigInteger getSeq() {
        return this.seq;
    }

}
