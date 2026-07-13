package com.sushitha.productcatalogservice.dtos;

import com.sushitha.productcatalogservice.models.Product;

public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;

    // Constructors
    public FakeStoreProductDTO() {}

    public FakeStoreProductDTO(Long id, String title, String description, double price, String category, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // Convert FakeStoreProductDTO to Product
    public Product toProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setCategory(this.category);
        product.setImage(this.image);
        return product;
    }
}