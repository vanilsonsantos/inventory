package com.mcompany.inventory.model;

import com.mcompany.inventory.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CounterRepository counterRepository;

    @Test
    public void shouldSaveAnItemInDatabase() {
        //given
        String nameFirstItem = "um item massa";

        //when
        Item firstItem = itemRepository.save(Item.item(counterRepository.getNextSequence("item"), nameFirstItem));

        //then
        assertThat(firstItem.getName(), is(nameFirstItem));
    }


}