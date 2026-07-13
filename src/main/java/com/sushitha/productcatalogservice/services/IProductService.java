package com.sushitha.productcatalogservice.services;

import com.sushitha.productcatalogservice.models.Product;
import java.util.List;

public interface IProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
}
