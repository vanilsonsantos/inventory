package com.mcompany.inventory.service;

import com.mcompany.inventory.builder.ItemBuilder;
import com.mcompany.inventory.model.Item;
import com.mcompany.inventory.model.repository.CounterRepository;
import com.mcompany.inventory.model.repository.ItemRepository;
import com.mcompany.inventory.view.ItemRequestResource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class ItemServiceTest {

    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private CounterRepository counterRepository;

    @Before
    public void setUp() {
        initMocks(this);
        itemService = new ItemService(itemRepository, counterRepository);
    }

    @Test
    public void shouldCreateItemBasedOnResource() {
        String nameExpectedItem = "farofa";
        ItemRequestResource itemResource = new ItemRequestResource(nameExpectedItem);

        Item item = new ItemBuilder().withName(nameExpectedItem).build();
        when(itemRepository.save(any(Item.class))).thenReturn(item);

        ResponseEntity resultItem = itemService.createItem(itemResource);

        assertThat(((Item)resultItem.getBody()).getName(), is(nameExpectedItem));
    }

    @Test
    public void shouldNotCreateItemWithSameName() {
        //given
        ItemRequestResource itemResource = new ItemRequestResource("mangueira");
        Item item = new ItemBuilder().withName(itemResource.getName()).build();
        when(itemRepository.findByName(any(String.class))).thenReturn(item);

        //when
        ResponseEntity response = itemService.createItem(itemResource);

        //then
        assertThat(response.getBody().toString(), is("You can not create an item with the same name"));
    }
}
