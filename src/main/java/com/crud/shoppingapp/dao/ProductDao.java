package com.crud.shoppingapp.dao;

import com.crud.shoppingapp.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product,Integer> {
//    List<Product> findAll();
}
