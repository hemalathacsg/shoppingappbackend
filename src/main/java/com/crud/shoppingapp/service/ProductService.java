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
        System.out.println("cart product quantity:  "+cart.getQuantity());
        Optional<Cart> existingCart = cartDao.findById(cart.getProductId());
        if (existingCart.isPresent()) {
            Cart currentCart = existingCart.get();
            currentCart.setQuantity(currentCart.getQuantity() + cart.getQuantity());
            return cartDao.save(currentCart);
        } else {
            return cartDao.save(cart);
        }
    }
    public List<Cart> getAllCartProducts() {
        return (List<Cart>) cartDao.findAll();
    }
    public void deleteCartProduct(int productId){
        Optional<Cart> cartproduct=cartDao.findById(productId);
        cartDao.delete(cartproduct.get());
    }
    public double totalCartPrice(){
        List<Cart> optionalCart= (List<Cart>) cartDao.findAll();
        return optionalCart.stream().mapToDouble(cart->cart.getProductDiscountPrice()*cart.getQuantity().doubleValue()).sum();
    }
//    public double totalCartProductsPrice() {
//        List<Cart> cartProducts = (List<Cart>) cartDao.findAll();
//        cartProducts.stream().mapToDouble(cart -> cart.getProductDiscountPrice().doubleValue()).forEach(s->System.out.println(s));
//        System.out.println("Working fine");
//        return cartProducts.stream().mapToDouble(cart -> cart.getProductDiscountPrice().doubleValue()).sum();
//    }

    public int incProdQuantity(int productId){
        Optional<Product> optionalProduct = productDao.findById(productId);
            Product product = optionalProduct.get();
            int newQuantity = product.getQuantity() + 1;
            product.setQuantity(newQuantity);
            productDao.save(product);
            return newQuantity;
    }
    public int decProdQuantity(int productId){
        Optional<Product> optionalProduct = productDao.findById(productId);
        Product product = optionalProduct.get();
        if(product.getQuantity()>1){
            product.setQuantity(product.getQuantity()-1);
            productDao.save(product);
            return product.getQuantity();
        }
        return product.getQuantity();
    }
    public int incCartProdQuantity(int productId){
        Optional<Cart> optionalCartProd=cartDao.findById(productId);
        Cart cartProd=optionalCartProd.get();
        cartProd.setQuantity(cartProd.getQuantity()+1);
        cartDao.save(cartProd);
        return cartProd.getQuantity();
    }
    public int decCartProdQuantity(int productId) {
        Optional<Cart> optionalCartProd = cartDao.findById(productId);
        Cart cartProd = optionalCartProd.get();
        if (cartProd.getQuantity() > 1) {
            cartProd.setQuantity(cartProd.getQuantity() - 1);
            cartDao.save(cartProd);
            return cartProd.getQuantity();
        }
        return cartProd.getQuantity();
    }
    public Optional<Product> viewProductDetails(int productId){
        return productDao.findById(productId);
    }
}
