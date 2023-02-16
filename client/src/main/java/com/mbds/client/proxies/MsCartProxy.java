package com.mbds.client.proxies;

import com.mbds.client.beans.CartBean;
import com.mbds.client.beans.CartItemBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "ms-cart", url = "localhost:8092")
public interface MsCartProxy {
    @PostMapping(value = "/cart")
    public ResponseEntity<CartBean> createNewCart(@RequestBody CartBean cartData);
    @GetMapping(value = "/cart/{id}")
    public ResponseEntity<CartBean> getCart(@PathVariable Long id);
    @PostMapping(value = "/cart/{id}/addProduct")
    public ResponseEntity<CartBean> addProductToCart(@PathVariable Long id, @RequestBody CartItemBean cartItem);

    @PostMapping(value = "/cart/{id}/deleteCartItem")
    public ResponseEntity<CartBean> deleteItems(@PathVariable Long id);

}
