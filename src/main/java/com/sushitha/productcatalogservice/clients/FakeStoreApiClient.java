package com.sushitha.productcatalogservice.clients;

import com.sushitha.productcatalogservice.dtos.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreApiClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<FakeStoreProductDTO> getForEntity(
            String url,
            Class<FakeStoreProductDTO> responseType,
            Object... uriVariables) {

        return restTemplate.getForEntity(
                url,
                responseType,
                uriVariables
        );
    }

    public ResponseEntity<FakeStoreProductDTO[]> getForEntityArray(
            String url,
            Class<FakeStoreProductDTO[]> responseType) {

        return restTemplate.getForEntity(
                url,
                responseType
        );
    }

    public ResponseEntity<FakeStoreProductDTO> putForEntity(
            String url,
            Object request,
            Class<FakeStoreProductDTO> responseType,
            Object... uriVariables) {

        return restTemplate.execute(
                url,
                HttpMethod.PUT,
                restTemplate.httpEntityCallback(request),
                restTemplate.responseEntityExtractor(responseType),
                uriVariables
        );
    }

    public boolean validateResponse(ResponseEntity<?> response) {

        return response.hasBody()
                && response.getStatusCode().value() == 200;
    }
}