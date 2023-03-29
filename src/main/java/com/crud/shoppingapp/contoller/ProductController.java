package com.crud.shoppingapp.contoller;

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
//    @PatchMapping("/addNewProduct")
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

//    @PostMapping("/addNewProduct")
//    public ResponseEntity<String> addNewProduct(@RequestBody Product product) {
//        productService.addProduct(product);
//        return ResponseEntity.ok("Product added successfully!");
//    }
    @GetMapping({"/getAllProduct"})
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
