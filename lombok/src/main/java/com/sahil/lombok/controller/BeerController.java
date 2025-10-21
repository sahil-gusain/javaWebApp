package com.sahil.lombok.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;

import com.sahil.lombok.model.Beer;
import com.sahil.lombok.service.BeerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
	private BeerService beerService;
	
	public Beer getBeerById(UUID id) {
		
		log.debug("get beer by id");
		return beerService.getBeerById(id);
	}
}
