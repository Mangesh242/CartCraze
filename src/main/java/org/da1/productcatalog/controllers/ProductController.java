package org.da1.productcatalog.controllers;

//bean is nothing but single ton class.
//in order to create bean some annotation should be add on class

import org.da1.productcatalog.models.Category;
import org.da1.productcatalog.models.Product;
import org.da1.productcatalog.models.State;
import org.da1.productcatalog.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        Product product1=new Product();
        product1.setId(1L);
        Category category1=new Category();

        products.add(product1);
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") long id){
//        Product product1=new Product();
        Product product1=productService.getProductById(id);
//        product1.setId(id);
        return product1;

    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        Product product1=new Product();
        product1.setId(product.getId());
        return product1;
    }
}

//As we need to have json response we will have to use @RestController annotation.
