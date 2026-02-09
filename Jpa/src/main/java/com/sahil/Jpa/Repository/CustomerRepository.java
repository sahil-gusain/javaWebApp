package com.sahil.Jpa.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.Jpa.entities.Beer;
import com.sahil.Jpa.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
