package com.mbds.order.controllers;

import com.mbds.order.model.Order;
import com.mbds.order.model.OrderItem;
import com.mbds.order.repositories.OrderItemRepository;
import com.mbds.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @PostMapping(value = "/order")
    public ResponseEntity<Order> createNewOrder(){
        Order order;
        try {
            order = orderRepository.save(new Order());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create a new order");
        }
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

    @GetMapping(value = "/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id){
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent())
            return new ResponseEntity<Order>(orderOptional.get(),HttpStatus.CREATED);

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Specified order doesn't exist");
    }

    @PostMapping(value = "/order/{id}/addCart")
    public ResponseEntity<Order> addCartItemToOrder(@PathVariable Long id, @RequestBody OrderItem orderItem){
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(!orderOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Specified order doesn't exist");
        Order order = orderOptional.get();
        order.addItems(orderItem);
        try {
            orderRepository.save(order);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create a new order");
        }
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

}
