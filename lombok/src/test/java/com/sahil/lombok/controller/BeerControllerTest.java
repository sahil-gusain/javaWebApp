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
     void getBeerById() throws Exception {
    	 Beer testBeer = beerImp.beerList().get(0);
    	 
    	 given(beerService.getBeerById(any(UUID.class))).willReturn(testBeer);
    	 
    	 
    	 mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
    			 .accept(MediaType.APPLICATION_JSON)) 
    	 		 .andExpect(status().isOk())
    	 		 .andExpect(content().contentType(MediaType.APPLICATION_JSON));

     
     }
     

     


}
