package com.LabDemo.productservice.controller;

import com.LabDemo.productservice.dto.ProductRequest;
import com.LabDemo.productservice.dto.ProductResponse;
import com.LabDemo.productservice.model.Product;
import com.LabDemo.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;


    @GetMapping("/data")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @Value("${app.title}")
    private String title;

    @GetMapping("/env")
    public ResponseEntity<String> showProductMsg() {
        return new ResponseEntity<String>("Value of title from Config Server: "+title, HttpStatus.OK);
    }

    @Value("${app.title1}")
    private String title1;

    @GetMapping("/env1")
    public ResponseEntity<String> showProductMsg1() {
        return new ResponseEntity<String>("Value of title from Config Server: "+title1, HttpStatus.OK);
    }

}
