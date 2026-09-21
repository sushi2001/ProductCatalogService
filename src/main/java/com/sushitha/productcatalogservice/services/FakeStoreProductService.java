package com.sushitha.productcatalogservice.services;

import com.sushitha.productcatalogservice.clients.FakeStoreApiClient;
import com.sushitha.productcatalogservice.dtos.FakeStoreProductDTO;
import com.sushitha.productcatalogservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    @Autowired
    private FakeStoreApiClient fakeStoreApiClient;

    private static final String BASE_URL =
            "https://fakestoreapi.com";

    @Override
    public Product getProductById(Long id) {

        ResponseEntity<FakeStoreProductDTO> response =
                fakeStoreApiClient.getForEntity(
                        BASE_URL + "/products/{id}",
                        FakeStoreProductDTO.class,
                        id
                );

        if (response.hasBody()
                && response.getStatusCode().value() == 200) {

            FakeStoreProductDTO dto = response.getBody();

            return dto.toProduct();
        }

        return null;
    }

    @Override
    public List<Product> getAllProducts() {

        ResponseEntity<FakeStoreProductDTO[]> response =
                fakeStoreApiClient.getForEntityArray(
                        BASE_URL + "/products",
                        FakeStoreProductDTO[].class
                );

        if (response.hasBody()
                && response.getStatusCode().value() == 200) {

            FakeStoreProductDTO[] dtos = response.getBody();

            List<Product> products = new ArrayList<>();

            for (FakeStoreProductDTO dto : dtos) {
                products.add(dto.toProduct());
            }

            return products;
        }

        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {

        FakeStoreProductDTO requestDto =
                product.convertToFakeStoreProductDTO();

        ResponseEntity<FakeStoreProductDTO> response =
                fakeStoreApiClient.putForEntity(
                        BASE_URL + "/products/{id}",
                        requestDto,
                        FakeStoreProductDTO.class,
                        id
                );

        if (response.hasBody()
                && response.getStatusCode().value() == 200) {

            FakeStoreProductDTO dto = response.getBody();

            return dto.toProduct();
        }

        return null;
    }
}