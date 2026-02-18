package com.sahil.Jpa.Mappers;

import org.mapstruct.Mapper;

import com.sahil.Jpa.entities.Beer;
import com.sahil.Jpa.model.BeerDTO;

@Mapper(componentModel = "spring")
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);

}