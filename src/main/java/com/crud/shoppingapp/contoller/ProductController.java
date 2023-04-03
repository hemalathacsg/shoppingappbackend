package com.crud.shoppingapp.contoller;

import com.crud.shoppingapp.entity.Cart;
import com.crud.shoppingapp.entity.Product;
import com.crud.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
    @DeleteMapping("/deleteCartProduct/{id}")
    public void deleteCartProduct(@PathVariable int productId){
        productService.deleteCartProduct(productId);
    }
}
