package com.sahil.lombok.service;


import java.util.List;
import java.util.UUID;

import com.sahil.lombok.model.Beer;


public interface BeerService {
	
	List<Beer> beerList();

    Beer getBeerById(UUID beerid);
}
