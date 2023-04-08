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
        // URL  localhost:8080/product
    }

    @GetMapping("/products/pagenumber/{pageNum}/pagesize/{pageSize}")
    public List<ProductResponse> getPagedProduct(@PathVariable int pageNum, @PathVariable int pageSize){

        List<ProductResponse> product = productService.getProducts(pageNum, pageSize);
        return product;
        //URL localhost:8080/products/pagenumber/0/pagesize/3
    }

    //Different way of a paged controller
    @GetMapping("/products")
    public List<ProductResponse> getNewPagedProduct(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber ,
         @RequestParam( value = "pageSize", defaultValue ="3", required = false ) Integer pageSize){

        List<ProductResponse> product = productService.getProducts(pageNumber, pageSize);
        return product;
        // Basic URL localhost:8080/products
        //Paged URL localhost:8080/products?pageNumber=1&pageSize=3
    }

    @PostMapping("product/create")
    public ProductResponse createProduct(@RequestBody ProductResponse productResponse){

        ProductResponse product = productService.createProduct(productResponse) ;

        return product;
        //URL localhost:8080/product/create
    }

}
