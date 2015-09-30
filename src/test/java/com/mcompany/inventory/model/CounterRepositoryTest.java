package com.mcompany.inventory.model;

import com.mcompany.inventory.Application;
import com.mcompany.inventory.model.repository.CounterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.lessThan;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CounterRepositoryTest {

    @Autowired
    private CounterRepository counterRepository;

    @Test
    public void shouldReturnNewSequenceFromPreviouslyIdGeneratedFromItemCollection(){
        //given
        Counter lastIdGeneratedFromCollection = counterRepository.getLastIdGenerated("item");

        //when
        int newSequence = counterRepository.getNextSequence("item");

        //then
        assertThat(lastIdGeneratedFromCollection.getSequence(), lessThan(newSequence));
    }
}
