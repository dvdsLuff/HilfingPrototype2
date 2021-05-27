package com.example.mercuriprototype.Service;


import com.example.mercuriprototype.domain.Product;
import com.example.mercuriprototype.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product create(Product product){
        return productRepository.save(product);
    }

    public void delete(int id){
        productRepository.deleteById(id);
    }

    public Product update(Product product){
      Optional<Product> optional =   productRepository.findById(product.getId());
        Product productDB = optional.get();
        productDB.setId(product.getId());
        productDB.setPrice(product.getPrice());
        productDB.setName(product.getName());
        productDB.setStocknumber(product.getStocknumber());

        return productRepository.save(productDB);
    }

    public Optional<Product> findById(Product product){
        return productRepository.findById(product.getId());
    }



}
