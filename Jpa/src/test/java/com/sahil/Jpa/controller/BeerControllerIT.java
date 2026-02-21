package com.sahil.Jpa.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.sahil.Jpa.Repository.BeerRepository;
import com.sahil.Jpa.entities.Beer;
import com.sahil.Jpa.model.BeerDTO;

import jakarta.transaction.Transactional;


@SpringBootTest
class BeerControllerIT {

	@Autowired
	BeerRepository beerRepository;
	
	@Autowired
	BeerController beerController;

	@Test
	void testBeerByIdNotNull() {
		assertThrows(NotFoundException.class, ()->{
			beerController.getBeerById(UUID.randomUUID());
		});
	}
	
	@Test
	void testGetBeerById() {
		Beer beer =beerRepository.findAll().get(0);
		System.out.println("Beer : "+beer.toString());
		 BeerDTO dto = beerController.getBeerById(beer.getId());
		 
		 assertThat(dto).isNotNull();
	}
	@Test
	void testListBeers() {
		List<BeerDTO> bdto = beerController.listBeers();
//		System.out.println(bdto.toString());
		assertThat(bdto.size()).isEqualTo(3);
	}
    @Rollback
    @Transactional
    @Test
    void testEmptyList() {
        beerRepository.deleteAll();
        List<BeerDTO> dtos = beerController.listBeers();

        assertThat(dtos.size()).isEqualTo(0);
    }
}
