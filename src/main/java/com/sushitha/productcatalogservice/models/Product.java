package com.sushitha.productcatalogservice.models;

import com.sushitha.productcatalogservice.dtos.ProductDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String title;
    private String description;
    private double price;
    private Category category;
    private String image;

    public ProductDTO toDTO() {

        ProductDTO dto = new ProductDTO();

        dto.setId(this.id);
        dto.setTitle(this.title);
        dto.setDescription(this.description);
        dto.setPrice(this.price);

        if (this.category != null) {
            dto.setCategory(this.category.getName());
        }

        dto.setImage(this.image);

        return dto;
    }
}