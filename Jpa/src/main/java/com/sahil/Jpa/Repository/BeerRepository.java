package com.sahil.Jpa.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.Jpa.entities.Beer;

public interface BeerRepository extends JpaRepository<Beer, UUID>{

}
