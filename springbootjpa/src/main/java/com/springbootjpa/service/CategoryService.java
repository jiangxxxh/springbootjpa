package com.springbootjpa.service;

import com.springbootjpa.domain.Category;

import java.util.Optional;

public interface CategoryService {

    void save(Category category);

    Optional<Category> findById(Integer id);
}
