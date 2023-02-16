package com.mbds.products.controllers;

import com.mbds.products.model.Product;
import com.mbds.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/products")
    public  List<Product> list(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @GetMapping(value = "/product/{id}")
    public Optional<Product> get(@PathVariable Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent())
            return product;

        throw new ResponseStatusException(HttpStatus.BAD_GATEWAY , "Specified product doesn't exist");
    }
}
