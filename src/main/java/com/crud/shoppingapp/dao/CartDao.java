package com.crud.shoppingapp.dao;

import com.crud.shoppingapp.entity.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartDao extends CrudRepository<Cart, Integer> {
    void deleteById(int productId);
}
