package org.example.service;

import org.example.pojo.ProductCart;
import org.example.pojo.ProductCategory;
import org.example.pojo.ProductItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BulkBuyLimitCategoryService {

    public static boolean validateBulkBuyLimitCategory(ProductCart cart) {
        HashMap<ProductItem, Integer> cartItems1 = cart.getCartItems();
        HashMap<ProductItem, Integer> cartItems = cartItems1;

        HashMap<ProductCategory, Integer> productItemsGrouped = new HashMap<>();

//        cartItems.entrySet().stream().collect(
//                Collectors.toMap(
//                        f -> {f.getKey().getCategory().getKey()},
//                        f -> {f.getValue()}
//                )
//        );

        Set<Map.Entry<ProductItem, Integer>> entries = cartItems1.entrySet();
        for (Map.Entry<ProductItem, Integer> item : entries) {
            Integer value = item.getValue();
            ProductCategory category = item.getKey().getCategory();
            Integer orDefault = productItemsGrouped.getOrDefault(category, 0);
            productItemsGrouped.put(category, orDefault+value);
        }

//    (f -> {
//            Integer numberOfItems = f.getValue();
//            String key = f.getKey().getCategory().getKey();
//
//        });

        return false;
    }

}
