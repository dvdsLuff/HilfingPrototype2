package com.example.mercuriprototype.Service;


import com.example.mercuriprototype.domain.Product;
import com.example.mercuriprototype.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public Product create(Product product){
        return productRepository.save(product);
    }


}
