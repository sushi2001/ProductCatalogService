package com.sushitha.productcatalogservice.models;

import lombok.Setter;
import lombok.Getter;
@Getter
@Setter

    public class Product extends BaseModel {
    /*
    name                          : String
    description                  : String
    price                            : Double
    imageUrl                     : String
    category                      : Category
    */

        private String name;
        private String description;
        private Double price;
        private String imageUrl;
        private Category category;
}
