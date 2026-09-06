package com.sushitha.productcatalogservice.dtos;

import com.sushitha.productcatalogservice.models.Category;
import com.sushitha.productcatalogservice.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDTO {

    private Long id;
    private String title;
    private String image;
    private String category;
    private String description;
    private Double price;

    public Product toProduct() {

        Product product = new Product();

        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImage(this.image);

        Category categoryObj = new Category();
        categoryObj.setName(this.category);

        product.setCategory(categoryObj);

        return product;
    }
}