package com.mcompany.inventory.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@NoArgsConstructor
public class ItemRequestResource {

    @Getter
    @NotEmpty(message = "This field can not be empty")
    private String name;

    public ItemRequestResource(String name) {
        this.name = name;
    }
}
