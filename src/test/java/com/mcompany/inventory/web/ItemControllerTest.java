package com.mcompany.inventory.web;


import com.jayway.restassured.RestAssured;
import com.mcompany.inventory.Application;
import com.mcompany.inventory.model.Item;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ItemControllerTest {

    private static Item newItem;

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {
        newItem = new Item(3L, "Cebola Roxa");
        RestAssured.port = port;
    }

    @Test
    public void shouldCreateAnItem() {

        when().
                post("/items/create/{name}", newItem.getName()).
        then().
                statusCode(200);
    }


    @Test
    public void shouldReturnItems() {

        when().
                get("/items").
        then().
                statusCode(200);
    }

    @Test
    public void shouldReturnItemsById() {

        when().

                get("/items/{id}", 0L).
        then().

                body("name", is("Jaca mole"));

    }

    @AfterClass
    public static void tearDown() {
        when().
                delete("/items/delete/{id}", newItem.getId()).
                then().
                statusCode(200);
    }

}
