package com.crud.shoppingapp.service;

import com.crud.shoppingapp.dao.ProductDao;
import com.crud.shoppingapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    public Product addNewProduct(Product product){
        //
        return productDao.save(product);
    }
    public List<Product> getAllProducts(){
        return (List<Product>)productDao.findAll();
    }
}
