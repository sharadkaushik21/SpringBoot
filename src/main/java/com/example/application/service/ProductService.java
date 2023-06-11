package com.example.application.service;

import com.example.application.dto.ProductResponse;

import java.util.List;


public interface ProductService {

    List<ProductResponse> getAllProduct();

    List<ProductResponse> getProducts(int pageNum, int pageSize, String sortBy);

    ProductResponse createProduct(ProductResponse productResponse);



}
