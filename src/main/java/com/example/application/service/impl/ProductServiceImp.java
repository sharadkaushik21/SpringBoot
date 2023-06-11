package com.example.application.service.impl;

import com.example.application.dao.Product;
import com.example.application.dto.ProductResponse;
import com.example.application.repository.ProductRepo;
import com.example.application.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepo productRepo;
  public List<ProductResponse> getAllProduct(){

      List<Product> productList = productRepo.findAll();

        List<ProductResponse> productResponseList = new ArrayList<>();
        for(Product product: productList ){
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(product,productResponse);
            productResponseList.add(productResponse);
        }
       //BeanUtils.copyProperties(productList, productResponseList);
      return productResponseList;
  }

    public List<ProductResponse> getProducts(int pageNum, int pageSize, String sortBy){

     //PageNumber initial value is 0
        Pageable pageable = PageRequest.of(pageNum,pageSize, Sort.by(sortBy) );
        Page<Product> pageProduct = productRepo.findAll(pageable);
        List<Product> productList = pageProduct.getContent();

        List<ProductResponse> productResponseList = new ArrayList<>();
        for(Product product: productList ){
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(product,productResponse);
            productResponseList.add(productResponse);
        }
        //BeanUtils.copyProperties(productList, productResponseList);
        return productResponseList;
    }

  public ProductResponse createProduct(ProductResponse productResponse ){

      Product product = new Product();
      BeanUtils.copyProperties(productResponse ,product);
      productRepo.save(product);
      return productResponse;
  }

}
