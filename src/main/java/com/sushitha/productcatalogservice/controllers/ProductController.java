package com.sushitha.productcatalogservice.controllers;

import com.sushitha.productcatalogservice.dtos.ProductDTO;
import com.sushitha.productcatalogservice.models.Product;
import com.sushitha.productcatalogservice.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(
            @PathVariable("id") Long id) {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Invalid product ID: cannot be zero or negative"
            );
        }

        Product product = productService.getProductById(id);

        if (product != null) {

            ProductDTO productDTO =
                    ProductDTO.from(product);

            return new ResponseEntity<>(
                    productDTO,
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
                HttpStatus.NOT_FOUND
        );
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {

        List<Product> products =
                productService.getAllProducts();

        if (products != null) {

            List<ProductDTO> productDTOs =
                    new ArrayList<>();

            for (Product product : products) {

                productDTOs.add(
                        ProductDTO.from(product)
                );
            }

            return new ResponseEntity<>(
                    productDTOs,
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
                HttpStatus.NOT_FOUND
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> replaceProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductDTO productDTO) {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Invalid product ID: cannot be zero or negative"
            );
        }

        Product product =
                productDTO.toProduct();

        Product updatedProduct =
                productService.replaceProduct(
                        id,
                        product
                );

        if (updatedProduct != null) {

            ProductDTO responseDTO =
                    ProductDTO.from(updatedProduct);

            return new ResponseEntity<>(
                    responseDTO,
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
                HttpStatus.NOT_FOUND
        );
    }
}