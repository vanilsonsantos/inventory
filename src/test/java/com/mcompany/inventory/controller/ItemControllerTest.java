package com.mcompany.inventory.controller;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.mcompany.inventory.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ItemControllerTest {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldCreateAnItem() {
        String expectedItem = "{\"name\":\"farofa\"}";

        given().
                contentType(ContentType.JSON).body(expectedItem).
        when().
                post("/inventory/item/create").
        then().
                statusCode(200).assertThat().body(equalTo(expectedItem));
    }

    @Test
    public void shouldReturnStatus400WhenReceivesAnInvalidBodyToCreateAnItem() {
        String expectedItem = "{\"invalidField\":\"travesseiro\"}";

        given().
                contentType(ContentType.JSON).body(expectedItem).
        when().
                post("/inventory/item/create").
        then().
                statusCode(400);
    }
}

