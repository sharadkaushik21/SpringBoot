package com.example.application.controller;

import com.example.application.dto.ProductResponse;
import com.example.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<ProductResponse> getAllProduct(){

        List<ProductResponse> product = productService.getAllProduct();

        return product;
    }

    @GetMapping("/products/pagenumber/{pageNum}/pagesize/{pageSize}")
    public List<ProductResponse> getPagedProduct(@PathVariable int pageNum, @PathVariable int pageSize){

        List<ProductResponse> product = productService.getProducts(pageNum, pageSize);

        return product;
    }

    @PostMapping("product/create")
    public ProductResponse createProduct(@RequestBody ProductResponse productResponse){

        ProductResponse product = productService.createProduct(productResponse) ;

        return product;
    }

}
