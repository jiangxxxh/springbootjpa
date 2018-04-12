package com.springbootjpa;

import com.springbootjpa.domain.Category;
import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.Product;
import com.springbootjpa.service.CategoryService;
import com.springbootjpa.service.MovieService;
import com.springbootjpa.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryTests {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @Test
    public void categorysave() {
        Category category = new Category();
        category.setName("泡面");
        category.setDescription("油炸");

        categoryService.save(category);
    }

    @Test
    public void productSave() {

        Category category = categoryService.findById(6).get();

        Product product = new Product();
        product.setName("红烧牛肉面");
        product.setPrice(2.5d);
        product.setDescription("康师傅");
        product.setCategory(category);

        productService.save(product);
    }

    @Test
    public void findProduct() {
        List<Product> list = productService.findAll();
        for(Product p:list){
            System.out.println(p.getName()+" "+p.getDescription()+" "+p.getCategory().getName());
        }
    }
}
