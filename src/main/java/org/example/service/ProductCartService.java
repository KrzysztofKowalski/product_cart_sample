package org.example.service;

import org.example.expection.BulkBuyLimitCategoryException;
import org.example.expection.BulkBuyLimitException;
import org.example.pojo.ProductCart;
import org.example.pojo.ProductItem;

import java.util.HashMap;

public class ProductCartService {

    private static final int MAX_PRODUCT_LIMIT = 10;

    public static boolean validateCart(ProductCart cart) {
        HashMap<ProductItem, Integer> cartItems = cart.getCartItems();
        return validateBulkBuyLimit(cart) &&
                validateBulkBuyLimitCategory(cart);
    }

    public static boolean validateBulkBuyLimit(ProductCart cart) throws BulkBuyLimitException {
        cart.getCartItems().entrySet().stream().forEach(f -> {
            if (f.getValue() > MAX_PRODUCT_LIMIT) {
                throw new BulkBuyLimitException();
            }
        });
        return true;
    }

    public static boolean validateBulkBuyLimitCategory(ProductCart cart) throws BulkBuyLimitCategoryException {
        return BulkBuyLimitCategoryService.validateBulkBuyLimitCategory(cart);
    }

}
