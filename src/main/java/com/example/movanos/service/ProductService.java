package com.example.movanos.service;

import com.example.movanos.entity.Product;
import com.example.movanos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> save(List<Product> products)
    {
        return productRepository.saveAll(products);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public String DeleteProduct(int id){
        productRepository.deleteById(id);
        return "Product Removed: "+id;
    }
    public Product UpdateProduct(Product product){
        Product existinProduct = productRepository.findById(product.getId()).orElse(null);
        existinProduct.setName(product.getName());
        existinProduct.setPrice(product.getPrice());
        existinProduct.setQuantity(product.getQuantity());
        return productRepository.save(existinProduct);
    }
}
