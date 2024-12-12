package org.da1.productcatalog.controllers;

import org.da1.productcatalog.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CategoryController {



    @GetMapping("/category")
    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        category.setId(2L);
        category.setName("house");
        categories.add(category);
        return categories;
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable Long id){

        Category category = new Category();
        category.setId(id);
        return category;

    }

}
