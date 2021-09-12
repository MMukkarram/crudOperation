package com.example.movanos.controller;

import com.example.movanos.entity.Product;
import com.example.movanos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/addproducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return productService.save(products);
    }

    @GetMapping("/getAllProduct")
    public List<Product> findAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getProductByid/{id}")
    public Product getProductByID(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("/getProductByName/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PutMapping("/updateproduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.UpdateProduct(product);
    }

    @DeleteMapping("/deleteProductByid/{id}")
    public String deleteProductByID(@PathVariable int id){
        return productService.DeleteProduct(id);
    }


}
