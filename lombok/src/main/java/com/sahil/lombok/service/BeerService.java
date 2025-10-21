package com.sahil.lombok.service;

import java.util.UUID;

import com.sahil.lombok.model.Beer;

public interface BeerService {

    Beer getBeerById(UUID id);
}
