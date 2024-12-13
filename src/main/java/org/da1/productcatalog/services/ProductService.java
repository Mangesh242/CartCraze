package org.da1.productcatalog.services;

import org.da1.productcatalog.dtos.FakeStoreProductDTO;
import org.da1.productcatalog.models.Category;
import org.da1.productcatalog.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
//        https://fakestoreapi.com/products

        return products;
    }

    public Product getProductById(Long productId) {

        RestTemplate restTemplate = restTemplateBuilder.build();

//        FakeStoreProductDTO fakeStoreProductDTO= restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}", FakeStoreProductDTO.class,productId).getBody();
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTORE = restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}", FakeStoreProductDTO.class,productId);
        System.out.println(fakeStoreProductDTORE.getStatusCode());
        if(fakeStoreProductDTORE.getBody() != null ) {
            return from(fakeStoreProductDTORE.getBody());
        }
        return null;

    }

    private Product from(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setName(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setDescription(fakeStoreProductDTO.getDescription());
        Category category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }


}
