package com.mcompany.inventory.service;

import com.mcompany.inventory.model.repository.CounterRepository;
import com.mcompany.inventory.model.Item;
import com.mcompany.inventory.model.repository.ItemRepository;
import com.mcompany.inventory.view.ItemRequestResource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

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
        //given
        String nameExpectedItem = "farofa";
        ItemRequestResource itemResource = new ItemRequestResource(nameExpectedItem);
        when(itemRepository.save(any(Item.class))).thenReturn(Item.item(1, nameExpectedItem));

        //when
        Item resultItem = itemService.createItem(itemResource);

        //then
        assertThat(resultItem.getName(), is(nameExpectedItem));
    }

    @Test
    public void shouldNotCreateItemWithSameName() {
        //given
        ItemRequestResource itemResource = new ItemRequestResource("mangueira");
        when(itemRepository.findByName(any(String.class))).thenReturn(Item.item(0,itemResource.getName()));

        try {
            //when
            itemService.createItem(itemResource);
        } catch (Exception e) {
            //then
            assertThat(e.getMessage(), is("You can create an item with the same name"));
        }
    }
}
