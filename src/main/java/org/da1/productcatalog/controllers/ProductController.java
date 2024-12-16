package org.da1.productcatalog.controllers;

//bean is nothing but single ton class.
//in order to create bean some annotation should be add on class

import org.da1.productcatalog.models.Category;
import org.da1.productcatalog.models.Product;
import org.da1.productcatalog.models.State;
import org.da1.productcatalog.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id){
//        Product product1=new Product();
        if(id<1 && id > 20){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Product product1=productService.getProductById(id);
//        product1.setId(id);
        if(product1==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product1, HttpStatus.OK);

    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        Product product1=new Product();
        product1.setId(product.getId());
        return product1;
    }
}

//As we need to have json response we will have to use @RestController annotation.
