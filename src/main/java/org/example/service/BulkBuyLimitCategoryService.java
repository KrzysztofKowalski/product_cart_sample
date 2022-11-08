package org.example.service;

import org.example.expection.BulkBuyLimitCategoryException;
import org.example.pojo.ProductCart;
import org.example.pojo.ProductCategory;
import org.example.pojo.ProductItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BulkBuyLimitCategoryService {

    private static final int PARACETAMOL_LIMIT = 5;
    private static final String PARACETAMOL_KEY = "paracetamol";

    public static boolean validateBulkBuyLimitCategory(ProductCart cart) {
        HashMap<ProductItem, Integer> cartItems1 = cart.getCartItems();
        HashMap<ProductCategory, Integer> productItemsGrouped = new HashMap<>();
        Set<Map.Entry<ProductItem, Integer>> entries = cartItems1.entrySet();
        for (Map.Entry<ProductItem, Integer> item : entries) {
            Integer value = item.getValue();
            ProductCategory category = item.getKey().getCategory();
            Integer orDefault = productItemsGrouped.getOrDefault(category, 0);
            productItemsGrouped.put(category, orDefault + value);
        }
        productItemsGrouped.entrySet().forEach(f -> {
            if (PARACETAMOL_KEY.equals(f.getKey().getKey())) {
                if (f.getValue() >= PARACETAMOL_LIMIT) {
                    throw new BulkBuyLimitCategoryException();
                }
            }
        });
        return true;
    }

}
