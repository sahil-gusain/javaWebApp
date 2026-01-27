package com.sahil.lombok.controller;


import java.net.http.HttpHeaders;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.lombok.model.BeerDTO;
import com.sahil.lombok.service.BeerService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {
	private final BeerService beerService;
	
    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";
	
	@PatchMapping(BEER_PATH_ID)
	public ResponseEntity<Void> updateBeerById(@PathVariable("beerId")UUID beerId,@RequestBody BeerDTO beer){
		
		beerService.updateBeerPatchById(beerId, beer);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(BEER_PATH_ID)
	public ResponseEntity<Void> deleteById(@PathVariable("beerId")UUID beerId){
		
		beerService.deleteById(beerId);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@PutMapping(BEER_PATH_ID)
	public ResponseEntity<Void> updateById(@PathVariable("beerId")UUID beerId,@RequestBody BeerDTO beer){
		
		beerService.updateBeerById(beerId,beer);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@PostMapping(BEER_PATH)
//	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewBeer(@RequestBody BeerDTO beer) {
		BeerDTO savedBeer  = beerService.saveNewBeer(beer);
		
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		
		header.add("Location", BEER_PATH+"/" + savedBeer.getBeerid());
		
		return new ResponseEntity<Void>(header   ,HttpStatus.CREATED);
	}
	
//	@ExceptionHandler( NotFoundException.class)
//	public ResponseEntity handleNotFoundExpection() {
//		return ResponseEntity.notFound().build();
//	}
//	
	 @RequestMapping(value=BEER_PATH,method = RequestMethod.GET)
	public  java.util.List<BeerDTO> beerList(){
		return beerService.beerList();
	}
	
	 @RequestMapping(value=BEER_PATH_ID,method = RequestMethod.GET)
	public BeerDTO getBeerById(@PathVariable("beerId") UUID beerid) {
		
		log.debug("get beer by beerid");
		return beerService.getBeerById(beerid).orElseThrow(NotFoundException::new);
	}
}
