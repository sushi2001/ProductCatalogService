package com.sushitha.productcatalogservice.models;
import java.util.List;

import lombok.Setter;
import lombok.Getter;
@Getter
@Setter


    public class Category extends BaseModel{
    /*
    name                          : String
    description                  : String
    products                     : List<Product>
     */

        private String name;
        private String description;

        private List<Product> products;

    }
