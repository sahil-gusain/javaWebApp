package com.sahil.lombok.controller;


import java.net.http.HttpHeaders;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.lombok.model.Beer;
import com.sahil.lombok.service.BeerService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	private final BeerService beerService;
	
	@PatchMapping("{beerId}")
	public ResponseEntity<Void> updateBeerById(@PathVariable("beerId")UUID beerId,@RequestBody Beer beer){
		
		beerService.updateBeerPatchById(beerId, beer);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{beerId}")
	public ResponseEntity<Void> deleteById(@PathVariable("beerId")UUID beerId){
		
		beerService.deleteById(beerId);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@PutMapping("{beerId}")
	public ResponseEntity<Void> updateById(@PathVariable("beerId")UUID beerId,@RequestBody Beer beer){
		
		beerService.updateBeerById(beerId,beer);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@PostMapping
//	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewBeer(@RequestBody Beer beer) {
		Beer savedBeer  = beerService.saveNewBeer(beer);
		
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		
		header.add("Location", "/api/v1/beer/" + savedBeer.getBeerid());
		
		return new ResponseEntity<Void>(header   ,HttpStatus.CREATED);
	}
	
	
	 @RequestMapping(method = RequestMethod.GET)
	public  java.util.List<Beer> beerList(){
		return beerService.beerList();
	}
	
	 @RequestMapping(value = "{beerid}",method = RequestMethod.GET)
	public Beer getBeerById(@PathVariable("beerid") UUID beerid) {
		
		log.debug("get beer by beerid");
		return beerService.getBeerById(beerid);
	}
}
