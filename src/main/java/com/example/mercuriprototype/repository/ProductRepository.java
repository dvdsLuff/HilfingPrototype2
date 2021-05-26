package com.example.mercuriprototype.repository;

import com.example.mercuriprototype.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
