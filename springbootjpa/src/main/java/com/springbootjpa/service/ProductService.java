package com.springbootjpa.service;

import com.springbootjpa.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    void save(Product product);

}
