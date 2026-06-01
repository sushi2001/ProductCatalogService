

package com.sushitha.productcatalogservice.controllers;

import com.sushitha.productcatalogservice.dtos.ProductRequestDTO;
import com.sushitha.productcatalogservice.dtos.ProductResponseDTO;

import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @PostMapping("/products")
    ProductResponseDTO createProduct(@RequestBody ProductRequestDTO product) {

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        return productResponseDTO;
    }

    @GetMapping("/products/{id}")
    ProductResponseDTO getProductById(@PathVariable("id") Long id) {

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        return productResponseDTO;
    }

    @GetMapping("/products")
    List<ProductResponseDTO> getAllProducts() {

        List<ProductResponseDTO> products = new ArrayList<>();

        return products;
    }
}
