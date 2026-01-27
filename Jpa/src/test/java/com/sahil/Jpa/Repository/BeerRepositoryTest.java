package com.sahil.Jpa.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.sahil.Jpa.entities.Beer;

@DataJpaTest
public class BeerRepositoryTest {
	
	
	@Autowired
	BeerRepository beerRepository;
	
	
	@Test
	void testBeer() {
		Beer savedBeer=beerRepository.save(Beer.builder().beerName("beer").build());
		
		assertThat(savedBeer).isNotNull();
		assertThat(savedBeer.getId()).isNotNull();
		
	}
	
}
