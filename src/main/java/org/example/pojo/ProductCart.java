package org.example.pojo;

import lombok.Data;

import java.util.HashMap;

@Data
public class ProductCart {

    private HashMap<ProductItem, Integer> cartItems;
}
