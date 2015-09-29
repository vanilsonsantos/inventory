package com.mcompany.inventory.service;

import com.mcompany.inventory.model.Item;
import com.mcompany.inventory.model.ItemRepository;
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

    @Before
    public void setUp() {
        initMocks(this);
        itemService = new ItemService(itemRepository);
    }

    @Test
    public void shouldCreateItemBasedOnResource() {
        //given
        String nameExpectedItem = "farofa";
        ItemRequestResource itemResource = new ItemRequestResource(nameExpectedItem);
        when(itemRepository.save(any(Item.class))).thenReturn(Item.item(nameExpectedItem));

        //when
        Item resultItem = itemService.createItem(itemResource);

        //then
        assertThat(resultItem.getName(), is(nameExpectedItem));
    }
}
