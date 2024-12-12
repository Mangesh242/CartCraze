package org.da1.productcatalog.controllers;

import org.da1.productcatalog.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoryController {


    public List<Category> getCategory(long id){
        return null;
    }
}
