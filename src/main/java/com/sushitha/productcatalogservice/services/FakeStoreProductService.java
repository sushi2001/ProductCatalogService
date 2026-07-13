package com.sushitha.productcatalogservice.services;

import com.sushitha.productcatalogservice.dtos.FakeStoreProductDTO;
import com.sushitha.productcatalogservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakeStoreProductService implements IProductService {

    private final RestTemplate restTemplate;
    private final String fakeStoreApiUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(fakeStoreApiUrl + "/" + id, FakeStoreProductDTO.class);

        if (response.getBody() != null) {
            return response.getBody().toProduct();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(fakeStoreApiUrl, FakeStoreProductDTO[].class);

        if (response.getBody() != null) {
            return Arrays.stream(response.getBody())
                    .map(FakeStoreProductDTO::toProduct)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}