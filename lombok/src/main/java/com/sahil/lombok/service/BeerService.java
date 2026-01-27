package com.sahil.lombok.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sahil.lombok.model.BeerDTO;


public interface BeerService {
	
	List<BeerDTO> beerList();

   Optional<BeerDTO>  getBeerById(UUID beerid);

	BeerDTO saveNewBeer(BeerDTO beer);

	void updateBeerById(UUID beerId, BeerDTO beer);

	void deleteById(UUID beerId);

	void updateBeerPatchById(UUID beerId, BeerDTO beer);
}
