package com.mcompany.inventory.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Counter {

    @Id
    private String Id;
    private int sequence;
}
