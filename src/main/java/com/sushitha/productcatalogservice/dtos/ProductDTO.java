package com.sushitha.productcatalogservice.dtos;

import com.sushitha.productcatalogservice.models.Category;
import com.sushitha.productcatalogservice.models.Product;

public class ProductDTO {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String title, String description,
                      double price, String category, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }

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

    public static ProductDTO from(Product product) {

        String categoryName = null;

        if (product.getCategory() != null) {
            categoryName = product.getCategory().getName();
        }

        return new ProductDTO(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                categoryName,
                product.getImage()
        );
    }

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
}