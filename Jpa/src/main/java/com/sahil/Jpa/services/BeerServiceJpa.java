package com.sahil.Jpa.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sahil.Jpa.Mappers.BeerMapper;
import com.sahil.Jpa.Repository.BeerRepository;
import com.sahil.Jpa.model.BeerDTO;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceJpa implements BeerService {

	private final BeerRepository beerRepository;
	private final BeerMapper beerMapper;
	
	
	
	@Override
	public List<BeerDTO> listBeers() {
		// TODO Auto-generated method stub
		return beerRepository.findAll()
				.stream()
				.map(beerMapper::beerToBeerDto)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<BeerDTO> getBeerById(UUID id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(beerMapper.beerToBeerDto(beerRepository.findById(id)
                .orElse(null)));
	}

	@Override
	public BeerDTO saveNewBeer(BeerDTO beer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBeerById(UUID beerId, BeerDTO beer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(UUID beerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void patchBeerById(UUID beerId, BeerDTO beer) {
		// TODO Auto-generated method stub

	}

}
