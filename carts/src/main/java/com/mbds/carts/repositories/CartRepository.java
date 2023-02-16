package com.mbds.carts.repositories;

import com.mbds.carts.model.Cart;
import com.mbds.carts.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
