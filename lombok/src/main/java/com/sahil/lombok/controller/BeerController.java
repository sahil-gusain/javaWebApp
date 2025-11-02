package com.sahil.lombok.controller;


import java.net.http.HttpHeaders;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.lombok.model.Beer;
import com.sahil.lombok.service.BeerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	private BeerService beerService;
	
	
	@PostMapping
//	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewBeer(@RequestBody Beer beer) {
		Beer savedBeer  = beerService.saveNewBeer(beer);
		
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		
		header.add("Locatin", "/api/v1/beer" + savedBeer.getBeerid());
		
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
