package com.sahil.lombok.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sahil.lombok.model.Beer;
import com.sahil.lombok.model.BeerStyle;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
	private Map<UUID,Beer> beerMap;
	
	
    public BeerServiceImpl() {
		
		this.beerMap = new HashMap<>();
		
		Beer beer1= Beer.builder()
				.beerid(UUID.randomUUID())
				.version(3)
                .beerName("kingfisher")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123567")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
		
	   Beer beer2= Beer.builder()
				.beerid(UUID.randomUUID())
				.version(3)
                .beerName("bira91")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();  
	   
		Beer beer3= Beer.builder()
				.beerid(UUID.randomUUID())
				.version(3)
                .beerName("IPA")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
		
		
		beerMap.put(beer3.getBeerid(), beer3);
		beerMap.put(beer1.getBeerid(), beer1);
		beerMap.put(beer2.getBeerid(), beer2);
	}

	@Override
    public Beer getBeerById(UUID beerid) {

        log.debug("Get Beer by Id - in service. Id: " + beerid.toString());

        return beerMap.get(beerid);
    }

	@Override
	public List<Beer> beerList() {
		// TODO Auto-generated method stub

		
		 return new ArrayList<>(beerMap.values());
	}
}

//path:/c/users/sahil/new-eclipse-workspace/lombok 
