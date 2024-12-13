package org.da1.productcatalog.services;

import org.da1.productcatalog.models.Product;

import java.util.List;

public interface IProductService {

    public List<Product> getAllProducts();
    public Product getProductById(Long id);

}
