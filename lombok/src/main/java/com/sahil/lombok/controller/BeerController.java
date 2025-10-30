package com.sahil.lombok.controller;


import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
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
