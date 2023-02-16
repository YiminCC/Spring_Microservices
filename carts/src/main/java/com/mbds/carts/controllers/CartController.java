package com.mbds.carts.controllers;

import com.mbds.carts.model.Cart;
import com.mbds.carts.model.CartItem;
import com.mbds.carts.repositories.CartItemRepository;
import com.mbds.carts.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class CartController {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartItemRepository cartItemRepository;

    @PostMapping(value = "/cart")
    public ResponseEntity<Cart> createNewCart(){
        Cart cart;
        try {
            cart = cartRepository.save(new Cart());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create a new cart");
        }
        return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
    }
    @GetMapping(value = "/cart/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id){
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if(cartOptional.isPresent())
            return new ResponseEntity<Cart>(cartOptional.get(),HttpStatus.CREATED);

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Specified cart doesn't exist");

    }
    @PostMapping(value = "/cart/{id}/addProduct")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long id, @RequestBody CartItem cartItem){
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if(!cartOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Specified cart doesn't exist");
        Cart cart = cartOptional.get();
        cart.addItems(cartItem);
        try {
           cartRepository.save(cart);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create a new cart");
        }
        return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
    }
    @PostMapping(value = "/cart/{id}/deleteCartItem")
    public ResponseEntity<Cart> deleteItems(@PathVariable Long id) {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if(!cartOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Specified cart doesn't exist");
        Cart cart = cartOptional.get();
        cart.deleteItems();
        try {
            cartRepository.save(cart);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't delete a new cart");
        }
        return new ResponseEntity<Cart>(cart, HttpStatus.NO_CONTENT);
    }

}
