package org.example;

import org.example.pojo.ProductCart;
import org.example.pojo.ProductCategory;
import org.example.pojo.ProductItem;
import org.example.service.ProductCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class ProductCartServiceTest {

    private ProductCart productCart;

    @BeforeEach
    public void beforeSetup() {
        productCart = new ProductCart();
        HashMap<ProductItem, Integer> productItemIntegerHashMap = new HashMap<>();
        ProductCategory paracetamol = new ProductCategory("Paracetamol");
        ProductCategory analgesic = new ProductCategory("analgesic");
        ProductCategory chocolate = new ProductCategory("chocolate");

        ProductItem product1 = new ProductItem(paracetamol, 1L);
        ProductItem product2 = new ProductItem(analgesic, 2L);
        ProductItem product3 = new ProductItem(chocolate, 3L);
        ProductItem product4 = new ProductItem(paracetamol, 4L);
        productItemIntegerHashMap.put(product1, 3);
        productItemIntegerHashMap.put(product2, 3);
        productItemIntegerHashMap.put(product3, 8);
        productItemIntegerHashMap.put(product4, 2);
        productCart.setCartItems(productItemIntegerHashMap);
    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
//        assertTrue( true );

        /**
         *
         Line-1 -> productid=1, category=Paracetamol, quantity=3

         Line-2 -> productid=2, category=analgesic, quantity=3

         Line-3 -> productid=3, category=chocolate, quantity=8

         Line-4 -> productid=4, category=Paracetamol, quantity=2

         */
        boolean b = ProductCartService.validateCart(productCart);
        assertTrue(b);
    }

    @Test
    public void badPathTest() {
        ProductCart productCart2 = new ProductCart();
        HashMap<ProductItem, Integer> productItemIntegerHashMap = new HashMap<>();
        ProductCategory paracetamol = new ProductCategory("Paracetamol");
        ProductCategory analgesic = new ProductCategory("analgesic");
        ProductCategory chocolate = new ProductCategory("chocolate");

        ProductItem product1 = new ProductItem(paracetamol, 1L);
        ProductItem product2 = new ProductItem(analgesic, 2L);
        ProductItem product3 = new ProductItem(chocolate, 3L);
        ProductItem product4 = new ProductItem(paracetamol, 4L);
        productItemIntegerHashMap.put(product1, 3);
        productItemIntegerHashMap.put(product2, 3);
        productItemIntegerHashMap.put(product3, 80);
        productItemIntegerHashMap.put(product4, 2);
        productCart2.setCartItems(productItemIntegerHashMap);
        boolean b = ProductCartService.validateCart(productCart);
        assertFalse(b);

    }
}
