package com.example.movanos;

import com.example.movanos.entity.Product;
import com.example.movanos.repository.ProductRepository;
import com.example.movanos.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class MovanosApplicationTests {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void getUserTest(){
        when(productRepository.findAll()).thenReturn(
                Stream.of(new Product(1,"Mobile",50,140000),new Product(2,"Charger",1000,1000))
                        .collect(Collectors.toList()));
        Assert.assertEquals(2,productService.getAllProducts().size());

    }
}
