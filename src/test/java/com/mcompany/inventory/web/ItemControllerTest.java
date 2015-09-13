package com.mcompany.inventory.web;


import com.jayway.restassured.RestAssured;
import com.mcompany.inventory.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.not;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ItemControllerTest {

    private final String newItemName = "Cebola Roxa";

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        ApplicationContext context = new FileSystemXmlApplicationContext("/migrations/dao.xml");
        context.getBean("mongeez");
    }

    @Test
    public void shouldCreateAnItem() {
        when().
                post("/items/create/{name}", newItemName).
        then().
                statusCode(200);
    }

    @Test
    public void shouldReturnItems() {
        expect().
                statusCode(200).
                body(not("[]")).
        when().
                get("/items");
    }

    @Test
    public void shouldReturnItemsById() {

    }
}
