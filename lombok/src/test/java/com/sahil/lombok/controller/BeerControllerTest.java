package com.sahil.lombok.controller;

import static org.mockito.ArgumentMatchers.any;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 	 	
import com.sahil.lombok.model.BeerDTO;
import com.sahil.lombok.service.BeerService;
import com.sahil.lombok.service.BeerServiceImpl;

@WebMvcTest(BeerController.class)
@AutoConfigureJson
@ExtendWith(MockitoExtension.class)
class BeerControllerTest {

     @Autowired
      MockMvc mockMvc;
     
     @Autowired
     com.fasterxml.jackson.databind.json.JsonMapper objectmapper;
     
     @MockitoBean
     BeerService beerService;
     
     BeerServiceImpl beerImp ;
     
     @Captor
     ArgumentCaptor<UUID> uuidCaptor;
     
     @Captor
     ArgumentCaptor<BeerDTO> beerCaptor;
     
     @BeforeEach
     void setup() {
    	 	beerImp = new BeerServiceImpl();
     }
     
     
     @Test
     void testUpdateById() throws JsonProcessingException, Exception {
    	    BeerDTO beer = beerImp.beerList().get(0);
    	    
    	    
    	    Map<String,Object> beermap=new HashMap();
    	    
    	    beermap.put("beerName", "shotgun");
    	    
    	    mockMvc.perform(patch(BeerController.BEER_PATH+"/"+ beer.getBeerid())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                            .content(objectmapper.writeValueAsString(beermap)))
                    .andExpect(status().isNoContent());
    	    
    	    
    	    verify(beerService).updateBeerPatchById(uuidCaptor.capture(), beerCaptor.capture());
    	    
    	    assertThat(beer.getBeerid()).isEqualTo(uuidCaptor.getValue());
            assertThat(beermap.get("beerName")).isEqualTo(beerCaptor.getValue().getBeerName());
    	    
     }
     
     
     @Test
     void  deleteBeerById() throws Exception {
    	 		BeerDTO beer  =  beerImp.beerList().get(0);
    	 		
    	 		mockMvc.perform(delete(BeerController.BEER_PATH+"/"+ beer.getBeerid())
    	 				.accept(MediaType.APPLICATION_JSON))
    	 				.andExpect(status().isNoContent());
    	 		
    	 		
    	 		verify(beerService).deleteById(uuidCaptor.capture());
    	 		
    	 		 assertThat(beer.getBeerid()).isEqualTo(uuidCaptor.getValue());
     }
     
     
     @Test
     void createNewBeer () throws Exception {
    	   BeerDTO beer  =  beerImp.beerList().get(0);
    	   
    	   beer.setBeerid(null);//because the beer id should be provided by random UUID
    	   beer.setVersion(null);
    	   
    	   given(beerService.saveNewBeer(any(BeerDTO.class))).willReturn(beer);
    	   
    	   mockMvc.perform(post(BeerController.BEER_PATH)
                   .accept(MediaType.APPLICATION_JSON)
                           .contentType(MediaType.APPLICATION_JSON)
                           .content(objectmapper.writeValueAsString(beer)))
                   .andExpect(status().isCreated())
                   .andExpect(header().exists("Location"));
    	 
    	   
     }
     
     @Test
     void updateBeerByIdTest () throws  Exception {
    	   BeerDTO beer = beerImp.beerList().get(0);
    	   
    	    mockMvc.perform(put(BeerController.BEER_PATH+"/"+beer.getBeerid())
    	    		.accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectmapper.writeValueAsString(beer)))
            .andExpect(status().isNoContent());
    	    
    	    verify(beerService).updateBeerById(any(UUID.class), any(BeerDTO.class));
    	    
    	    //any does not care about the value just types
    	    //verify is used to check if this method is called or not
    	    
     }
     
  
     
      
     
     @Test
     void testListBeer() throws Exception {
    	 
    	 	given(beerService.beerList()).willReturn(beerImp.beerList());
    	 	
    	 	mockMvc.perform(get(BeerController.BEER_PATH)
    	 			.accept(MediaType.APPLICATION_JSON))
    	 			.andExpectAll(status().isOk())
    	 			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
    	 			.andExpect(jsonPath("$.length()", is(3)));
    	 
     }
     
     @Test
     void getBeerByIdNotFound() throws Exception {
    	 
    	 given(beerService.getBeerById(any(UUID.class))).willReturn(Optional.empty());
    	 
    	 mockMvc.perform(get(BeerController.BEER_PATH_ID,UUID.randomUUID()))
    			 .andExpect(status().isNotFound());
     }
  
     
     @Test
     void getBeerById() throws Exception {
    	 BeerDTO testBeer = beerImp.beerList().get(0);
    	 
    	 given(beerService.getBeerById(testBeer.getBeerid())).willReturn(Optional.of(testBeer));
    	 
    	 
    	 mockMvc.perform(get(BeerController.BEER_PATH+"/" + testBeer.getBeerid())
    			 .accept(MediaType.APPLICATION_JSON)) 
    	 		 .andExpect(status().isOk())
    	 		 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    	 		.andExpect(jsonPath("$.beerid", is(testBeer.getBeerid().toString())))
    	 		 .andExpect(jsonPath("$.beerName", is(testBeer.getBeerName())));
   	 
     }
     

     


}
