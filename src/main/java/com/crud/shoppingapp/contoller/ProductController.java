package com.crud.shoppingapp.contoller;

import com.crud.shoppingapp.entity.Cart;
import com.crud.shoppingapp.entity.Product;
import com.crud.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin("*")

public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping("/addNewProduct")
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

    @GetMapping({"/getAllProduct"})
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/addToCart")
    public Cart addToCart(@RequestBody Cart cart){
        return productService.addToCart(cart);
    }
    @GetMapping("/getAllCartProducts")
    public List<Cart> getAllCartProducts(){
        return productService.getAllCartProducts();
    }
    @DeleteMapping("/deleteCartProduct/{productId}")
    public void deleteCartProduct(@PathVariable int productId){
        productService.deleteCartProduct(productId);
    }
    @GetMapping("/totalCartProductsPrice")
    public double totalCartProductsPrice(){
        return productService.totalCartProductsPrice();
    }
    @PostMapping("/incProdQuantity/{productId}")
    public int incProdQuantity(@PathVariable int productId) {
        return productService.incProdQuantity(productId);
    }
    @PostMapping("/decProdQuantity/{productId}")
    public int decProdQuantity(@PathVariable int productId){
        return productService.decProdQuantity(productId);
    }
    @PostMapping("/incCartProdQuantity/{productId}")
    public int incCartProdQuantity(@PathVariable int productId){
        return productService.incCartProdQuantity(productId);
    }
    @PostMapping("/decCartProdQuantity/{productId}")
    public int decCartProdQuantity(@PathVariable int productId){
        return productService.decCartProdQuantity(productId);
    }
    @GetMapping("/viewProductDetails/{productId}")
    public Optional<Product> viewProductDetails(@PathVariable int productId){
        return productService.viewProductDetails(productId);
    }
}
