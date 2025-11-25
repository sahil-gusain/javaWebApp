package com.sahil.lombok.controller;

import static org.mockito.ArgumentMatchers.any;

import java.util.UUID;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




import com.sahil.lombok.model.Beer;
import com.sahil.lombok.service.BeerService;
import com.sahil.lombok.service.BeerServiceImpl;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

     @Autowired
      MockMvc mockMvc;
     
     @MockitoBean
     BeerService beerService;
     
     BeerServiceImpl beerImp = new BeerServiceImpl();
     
     @Test
     void testListBeer() throws Exception {
    	 
    	 	given(beerService.beerList()).willReturn(beerImp.beerList());
    	 	
    	 	mockMvc.perform(get("/api/v1/beer")
    	 			.accept(MediaType.APPLICATION_JSON))
    	 			.andExpectAll(status().isOk())
    	 			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
    	 			.andExpect(jsonPath("$.length()", is(3)));
    	 
     }
     
     
     
     
     
     @Test
     void getBeerById() throws Exception {
    	 Beer testBeer = beerImp.beerList().get(0);
    	 
    	 given(beerService.getBeerById(testBeer.getBeerid())).willReturn(testBeer);
    	 
    	 
    	 mockMvc.perform(get("/api/v1/beer/" + testBeer.getBeerid())
    			 .accept(MediaType.APPLICATION_JSON)) 
    	 		 .andExpect(status().isOk())
    	 		 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    	 		.andExpect(jsonPath("$.beerid", is(testBeer.getBeerid().toString())))
    	 		 .andExpect(jsonPath("$.beerName", is(testBeer.getBeerName())));

    	 
     }
     

     


}
