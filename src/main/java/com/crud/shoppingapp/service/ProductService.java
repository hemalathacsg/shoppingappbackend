package com.crud.shoppingapp.service;

import com.crud.shoppingapp.dao.CartDao;
import com.crud.shoppingapp.dao.ProductDao;
import com.crud.shoppingapp.entity.Cart;
import com.crud.shoppingapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CartDao cartDao;

    public Product addNewProduct(Product product) {
        //
        return productDao.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productDao.findAll();
    }

    public Cart addToCart(Cart cart) {
        return cartDao.save(cart);
    }

    public List<Cart> getAllCartProducts() {
        return (List<Cart>) cartDao.findAll();
    }
    public void deleteCartProduct(int productId){
        cartDao.deleteById(productId);
    }
}
