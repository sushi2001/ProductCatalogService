package com.sushitha.productcatalogservice.services;

import com.sushitha.productcatalogservice.dtos.FakeStoreProductDTO;
import com.sushitha.productcatalogservice.models.Category;
import com.sushitha.productcatalogservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Product getProductById(Long id) {

        FakeStoreProductDTO fakeStoreProductDTO =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDTO.class
                );

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDTO[] fakeStoreProductDTOs =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDTO[].class
                );

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDTO dto : fakeStoreProductDTOs) {
            products.add(convertFakeStoreProductDtoToProduct(dto));
        }

        return products;
    }

    private Product convertFakeStoreProductDtoToProduct(
            FakeStoreProductDTO fakeStoreProductDTO) {

        Product product = new Product();

        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImage(fakeStoreProductDTO.getImage());

        Category category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());

        product.setCategory(category);

        return product;
    }
}