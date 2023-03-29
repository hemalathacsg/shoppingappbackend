package com.crud.shoppingapp.contoller;

import com.crud.shoppingapp.entity.Product;
import com.crud.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CartController {

        @Autowired
        private ProductService productService;
//        @PostMapping("/addNewProduct")
//        public Product addNewProduct(@RequestBody Product product){
//            return productService.addNewProduct(product);
//        }
        @GetMapping({"/getAllCartProduct"})
        public List<Product> getAllCartProducts(){
            return productService.getAllProducts();
        }
}
