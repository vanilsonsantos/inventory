package com.mcompany.inventory.service;

/**
 * Created by vsantos on 9/29/15.
 */
public class ItemAlreadyExistsException extends RuntimeException {

    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
