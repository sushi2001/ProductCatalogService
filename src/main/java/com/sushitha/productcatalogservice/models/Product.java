package com.sushitha.productcatalogservice.models;

import com.sushitha.productcatalogservice.dtos.FakeStoreProductDTO;
import com.sushitha.productcatalogservice.dtos.ProductDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel {

    private String title;
    private String description;
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    private String image;

    public ProductDTO toDTO() {

        ProductDTO dto = new ProductDTO();

        dto.setId(this.getId());
        dto.setTitle(this.title);
        dto.setDescription(this.description);
        dto.setPrice(this.price);

        if (this.category != null) {
            dto.setCategory(this.category.getName());
        }

        dto.setImage(this.image);

        return dto;
    }

    public FakeStoreProductDTO convertToFakeStoreProductDTO() {

        FakeStoreProductDTO dto = new FakeStoreProductDTO();

        dto.setId(this.getId());
        dto.setTitle(this.title);
        dto.setPrice(this.price);
        dto.setDescription(this.description);
        dto.setImage(this.image);

        if (this.category != null) {
            dto.setCategory(this.category.getName());
        }

        return dto;
    }
}